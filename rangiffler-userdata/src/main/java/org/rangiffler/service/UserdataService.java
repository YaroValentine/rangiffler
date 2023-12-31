package org.rangiffler.service;

import jakarta.annotation.Nonnull;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.rangiffler.data.FriendsEntity;
import org.rangiffler.data.UserEntity;
import org.rangiffler.data.model.FriendJson;
import org.rangiffler.data.model.FriendStatus;
import org.rangiffler.data.model.UserJson;
import org.rangiffler.data.repository.UserRepository;
import org.rangiffler.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class UserdataService {

    private static final Logger LOG = LoggerFactory.getLogger(UserdataService.class);

    private final UserRepository userRepository;

    @Autowired
    public UserdataService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @KafkaListener(topics = "users", groupId = "userdata")
    public void listener(@Payload UserJson user, ConsumerRecord<String, UserJson> cr) {
        LOG.info("### Kafka topic [users] received message: " + user.getUsername());
        LOG.info("### Kafka consumer record: " + cr.toString());
        UserEntity userDataEntity = new UserEntity();
        userDataEntity.setUsername(user.getUsername());
        UserEntity userEntity = userRepository.save(userDataEntity);
        LOG.info(String.format(
                "### User '%s' successfully saved to database with id: %s",
                user.getUsername(),
                userEntity.getId()
        ));
    }

    public @Nonnull
    UserJson update(@Nonnull UserJson user) {
        UserEntity userEntity = userRepository.findByUsername(user.getUsername());
        if (userEntity == null) {
            throw new NotFoundException("Can`t find user by username: " + user.getUsername());
        }
        userEntity.setFirstname(user.getFirstName());
        userEntity.setSurname(user.getLastName());
        userEntity.setAvatar(user.getPhoto() != null ? user.getPhoto().getBytes(StandardCharsets.UTF_8) : null);
        UserEntity saved = userRepository.save(userEntity);

        return UserJson.fromEntity(saved);
    }

    public @Nonnull
    UserJson getCurrentUser(@Nonnull String username) {
        UserEntity userDataEntity = userRepository.findByUsername(username);
        if (userDataEntity == null) {
            throw new NotFoundException("Can`t find user by username: " + username);
        } else {
            return UserJson.fromEntity(userDataEntity);
        }
    }

    public @Nonnull
    List<UserJson> allUsers(@Nonnull String username) {
        Map<UUID, UserJson> result = new HashMap<>();
        for (UserEntity user : userRepository.findByUsernameNot(username)) {
            List<FriendsEntity> sendInvites = user.getFriends();
            List<FriendsEntity> receivedInvites = user.getInvites();

            if (!sendInvites.isEmpty() || !receivedInvites.isEmpty()) {
                Optional<FriendsEntity> inviteToMe = sendInvites.stream()
                        .filter(i -> i.getFriend().getUsername().equals(username))
                        .findFirst();

                Optional<FriendsEntity> inviteFromMe = receivedInvites.stream()
                        .filter(i -> i.getUser().getUsername().equals(username))
                        .findFirst();

                if (inviteToMe.isPresent()) {
                    FriendsEntity invite = inviteToMe.get();
                    result.put(user.getId(), UserJson.fromEntity(user, invite.isPending()
                            ? FriendStatus.INVITATION_RECEIVED
                            : FriendStatus.FRIEND));
                }
                if (inviteFromMe.isPresent()) {
                    FriendsEntity invite = inviteFromMe.get();
                    result.put(user.getId(), UserJson.fromEntity(user, invite.isPending()
                            ? FriendStatus.INVITATION_SENT
                            : FriendStatus.FRIEND));
                }
            }
            if (!result.containsKey(user.getId())) {
                result.put(user.getId(), UserJson.fromEntity(user, FriendStatus.NOT_FRIEND));
            }
        }
        return new ArrayList<>(result.values());
    }

    public @Nonnull
    List<UserJson> friends(@Nonnull String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new NotFoundException("Can`t find user by username: " + username);
        }
        return userEntity
                .getFriends()
                .stream()
                .filter(fe -> !fe.isPending())
                .map(fe -> UserJson.fromEntity(fe.getFriend(), fe.isPending()
                        ? FriendStatus.INVITATION_SENT
                        : FriendStatus.FRIEND))
                .toList();
    }

    public @Nonnull
    List<UserJson> invitations(@Nonnull String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity == null) {
            throw new NotFoundException("Can`t find user by username: " + username);
        }
        return userEntity
                .getInvites()
                .stream()
                .filter(FriendsEntity::isPending)
                .map(fe -> UserJson.fromEntity(fe.getUser(), FriendStatus.INVITATION_RECEIVED))
                .toList();
    }

    public UserJson addFriend(@Nonnull String username, @Nonnull FriendJson friend) {
        UserEntity currentUser = userRepository.findByUsername(username);
        UserEntity friendEntity = userRepository.findByUsername(friend.getUsername());
        if (currentUser == null) {
            throw new NotFoundException("Can`t find user by username: " + username);
        }
        if (friendEntity == null) {
            throw new NotFoundException("Can`t find user by username: " + friend.getUsername());
        }
        currentUser.addFriends(true, friendEntity);
        userRepository.save(currentUser);
        return UserJson.fromEntity(friendEntity, FriendStatus.INVITATION_SENT);
    }

    public @Nonnull
    UserJson acceptInvitation(@Nonnull String username, @Nonnull FriendJson invitation) {
        UserEntity currentUser = userRepository.findByUsername(username);
        UserEntity inviteUser = userRepository.findByUsername(invitation.getUsername());
        if (currentUser == null) {
            throw new NotFoundException("Can`t find user by username: " + username);
        }
        if (inviteUser == null) {
            throw new NotFoundException("Can`t find user by username: " + invitation.getUsername());
        }

        FriendsEntity invite = currentUser.getInvites()
                .stream()
                .filter(fe -> fe.getUser().getUsername().equals(inviteUser.getUsername()))
                .findFirst()
                .orElseThrow();

        invite.setPending(false);
        currentUser.addFriends(false, inviteUser);
        userRepository.save(currentUser);

        return UserJson.fromEntity(inviteUser, FriendStatus.FRIEND);
    }

    @Transactional
    public @Nonnull
    UserJson declineInvitation(@Nonnull String username, @Nonnull UserJson invitation) {
        UserEntity currentUser = userRepository.findByUsername(username);
        UserEntity friendToDecline = userRepository.findByUsername(invitation.getUsername());
        if (currentUser == null) {
            throw new NotFoundException("Can`t find user by username: " + username);
        }
        if (friendToDecline == null) {
            throw new NotFoundException("Can`t find user by username: " + invitation.getUsername());
        }

        currentUser.removeInvites(friendToDecline);
        friendToDecline.removeFriends(currentUser);

        userRepository.save(currentUser);
        userRepository.save(friendToDecline);

        return UserJson.fromEntity(currentUser, FriendStatus.NOT_FRIEND);
    }

    @Transactional
    public @Nonnull
    UserJson removeFriend(@Nonnull String username, @Nonnull String friendUsername) {
        UserEntity currentUser = userRepository.findByUsername(username);
        UserEntity friendToRemove = userRepository.findByUsername(friendUsername);
        if (currentUser == null) {
            throw new NotFoundException("Can`t find user by username: " + username);
        }
        if (friendToRemove == null) {
            throw new NotFoundException("Can`t find user by username: " + friendToRemove);
        }

        currentUser.removeFriends(friendToRemove);
        currentUser.removeInvites(friendToRemove);
        friendToRemove.removeFriends(currentUser);
        friendToRemove.removeInvites(currentUser);

        userRepository.save(currentUser);
        userRepository.save(friendToRemove);

        return UserJson.fromEntity(friendToRemove, FriendStatus.NOT_FRIEND);
    }

}
