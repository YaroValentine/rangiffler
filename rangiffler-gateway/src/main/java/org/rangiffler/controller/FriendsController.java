package org.rangiffler.controller;

import jakarta.annotation.Nonnull;
import org.rangiffler.model.FriendJson;
import org.rangiffler.model.UserJson;
import org.rangiffler.service.RestUserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendsController {

    private static final Logger LOG = LoggerFactory.getLogger(FriendsController.class);
    private final RestUserClient userDataClient;

    @Autowired
    public FriendsController(@Qualifier("rest") RestUserClient userDataClient) {
        this.userDataClient = userDataClient;
    }

    @GetMapping("/friends")
    public List<UserJson> friends(@AuthenticationPrincipal Jwt principal,
                                             @RequestParam boolean includePending) {
        String username = principal.getClaim("sub");
        return userDataClient.friends(username, includePending);
    }

    @GetMapping("/invitations")
    public List<UserJson> invitations(@AuthenticationPrincipal Jwt principal) {
        String username = principal.getClaim("sub");
        return userDataClient.invitations(username);
    }

    @PostMapping("/acceptInvitation")
    public List<UserJson> acceptInvitation(@AuthenticationPrincipal Jwt principal,
                                           @Validated @RequestBody FriendJson invitation) {
        String username = principal.getClaim("sub");
        return userDataClient.acceptInvitation(username, invitation);
    }

    @PostMapping("/friends/decline")
    public List<UserJson> declineInvitation(@AuthenticationPrincipal Jwt principal,
                                        @Validated @RequestBody FriendJson invitation) {
        String username = principal.getClaim("sub");
        return userDataClient.declineInvitation(username, invitation);
    }

    @PostMapping("/addFriend")
    public UserJson sendInvitation(@AuthenticationPrincipal Jwt principal,
                                   @Validated @RequestBody FriendJson friend) {
        String username = principal.getClaim("sub");
        return userDataClient.addFriend(username, friend);
    }

    @PostMapping("/friends/remove")
    public @Nonnull
    List<UserJson> removeFriendFromUser(@AuthenticationPrincipal Jwt principal,
                                        @RequestParam("username") String friendUsername) {
        String username = principal.getClaim("sub");
        return userDataClient.removeFriend(username, friendUsername);
    }
}
