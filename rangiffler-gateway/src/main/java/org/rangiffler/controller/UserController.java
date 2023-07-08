package org.rangiffler.controller;

import jakarta.annotation.Nonnull;
import org.rangiffler.model.FriendJson;
import org.rangiffler.model.UserJson;
import org.rangiffler.service.RestUserService;
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
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private final RestUserService userDataClient;

    @Autowired
    public UserController(@Qualifier("rest") RestUserService userDataClient) {
        this.userDataClient = userDataClient;
    }

    @GetMapping("/users")
    public List<UserJson> getAllUsers(@AuthenticationPrincipal Jwt principal) {
        String username = principal.getClaim("sub");
        return userDataClient.allUsers(username);
    }

    @GetMapping("/currentUser")
    public UserJson getCurrentUser(@AuthenticationPrincipal Jwt principal) {
        String username = principal.getClaim("sub");
        return userDataClient.currentUser(username);
    }

    @GetMapping("/currentUser")
//    @PatchMapping("/updateUserInfo")
    public UserJson updateCurrentUser(@AuthenticationPrincipal Jwt principal,
                                      @Validated @RequestBody UserJson user) {
        String username = principal.getClaim("sub");
        user.setUsername(username);
        return userDataClient.updateUserInfo(user);
    }

    @GetMapping("/friends")
    public List<UserJson> getFriendsByUserId(@AuthenticationPrincipal Jwt principal,
                                             @RequestParam boolean includePending) {
        String username = principal.getClaim("sub");
        return userDataClient.friends(username, includePending);
    }

    @GetMapping("invitations")
    public List<UserJson> getInvitations(@AuthenticationPrincipal Jwt principal) {
        String username = principal.getClaim("sub");
        return userDataClient.invitations(username);
    }

    @PostMapping("/addFriend")
    //    @PostMapping("/addFriend")
    public UserJson sendInvitation(@AuthenticationPrincipal Jwt principal,
                                   @Validated @RequestBody FriendJson friend) {
        String username = principal.getClaim("sub");
        return userDataClient.addFriend(username, friend);
    }

    @PostMapping("friends/remove")
//    @PostMapping("/removeFriend")
    public @Nonnull
    List<UserJson> removeFriendFromUser(@AuthenticationPrincipal Jwt principal,
                                         @RequestParam("username") String friendUsername) {
        String username = principal.getClaim("sub");
        return userDataClient.removeFriend(username, friendUsername);
    }

    @PostMapping("/acceptInvitation")
    public List<UserJson> acceptInvitation(@AuthenticationPrincipal Jwt principal,
                                           @Validated @RequestBody FriendJson invitation) {
        String username = principal.getClaim("sub");
        return userDataClient.acceptInvitation(username, invitation);
    }

    @PostMapping("friends/decline")
    public List<UserJson> declineFriend(@AuthenticationPrincipal Jwt principal,
                                  @Validated @RequestBody FriendJson invitation) {
        String username = principal.getClaim("sub");
        return userDataClient.declineInvitation(username, invitation);
    }
}
