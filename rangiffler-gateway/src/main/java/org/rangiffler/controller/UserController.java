package org.rangiffler.controller;

import org.rangiffler.model.UserJson;
import org.rangiffler.service.RestUserClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);
    private final RestUserClient userDataClient;

    @Autowired
    public UserController(@Qualifier("rest") RestUserClient userDataClient) {
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

    @PatchMapping("/currentUser")
    public UserJson updateCurrentUser(@AuthenticationPrincipal Jwt principal,
                                      @Validated @RequestBody UserJson user) {
        String username = principal.getClaim("sub");
        user.setUsername(username);
        return userDataClient.updateUserInfo(user);
    }

}
