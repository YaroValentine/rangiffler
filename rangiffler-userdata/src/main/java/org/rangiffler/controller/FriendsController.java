package org.rangiffler.controller;

import org.rangiffler.data.model.FriendJson;
import org.rangiffler.data.model.UserJson;
import org.rangiffler.service.UserdataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FriendsController {

    private final UserdataService userService;

    @Autowired
    public FriendsController(UserdataService userService) {
        this.userService = userService;
    }

    @GetMapping("/friends")
    public List<UserJson> friends(@RequestParam String username) {
        return userService.friends(username);
    }

    @GetMapping("/invitations")
    public List<UserJson> invitations(@RequestParam String username) {
        return userService.invitations(username);
    }

    @PostMapping("/acceptInvitation")
    public UserJson acceptInvitation(@RequestParam String username,
                                           @RequestBody FriendJson invitation) {
        return userService.acceptInvitation(username, invitation);
    }

    @PostMapping("/friends/decline")
    public List<UserJson> declineInvitation(@RequestParam String username,
                                            @RequestBody FriendJson invitation) {
        return userService.declineInvitation(username, invitation);
    }

    @PostMapping("/addFriend")
    public UserJson addFriend(@RequestParam String username,
                              @RequestBody FriendJson friend) {
        return userService.addFriend(username, friend);
    }

    @DeleteMapping("/friends/remove")
    public List<UserJson> removeFriend(@RequestParam String username,
                                       @RequestParam String friendUsername) {
        return userService.removeFriend(username, friendUsername);
    }
}
