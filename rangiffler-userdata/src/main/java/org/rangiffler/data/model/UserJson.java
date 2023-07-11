package org.rangiffler.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import org.rangiffler.data.UserEntity;

import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.UUID;

public class UserJson {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("username")
    private String username;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("avatar")
    private String avatar;

    @JsonProperty("friendStatus")
    private FriendState friendStatus;

    public UserJson() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstname) {
        this.firstName = firstname;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String surname) {
        this.lastName = surname;
    }

    public String getPhoto() {
        return avatar;
    }

    public void setPhoto(String avatar) {
        this.avatar = avatar;
    }

    public FriendState getFriendState() {
        return friendStatus;
    }

    public void setFriendState(FriendState friendStatus) {
        this.friendStatus = friendStatus;
    }

    public static UserJson fromEntity(UserEntity entity) {
        UserJson usr = new UserJson();
        byte[] avatar = entity.getAvatar();
        usr.setId(entity.getId());
        usr.setUsername(entity.getUsername());
        usr.setFirstName(entity.getFirstname());
        usr.setLastName(entity.getSurname());
        usr.setPhoto(avatar != null && avatar.length > 0 ? new String(entity.getAvatar(), StandardCharsets.UTF_8) : null);
        return usr;
    }

    public static UserJson fromEntity(UserEntity entity, FriendState friendStatus) {
        UserJson userJson = fromEntity(entity);
        userJson.setFriendState(friendStatus);
        return userJson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJson userJson = (UserJson) o;
        return Objects.equals(id, userJson.id) && Objects.equals(username, userJson.username)
                && Objects.equals(firstName, userJson.firstName)
                && Objects.equals(lastName, userJson.lastName)
                && Objects.equals(avatar, userJson.avatar)
                && friendStatus == userJson.friendStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, firstName, lastName, avatar, friendStatus);
    }
}
