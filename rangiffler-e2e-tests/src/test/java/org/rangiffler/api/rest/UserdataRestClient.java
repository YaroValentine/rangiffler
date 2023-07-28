package org.rangiffler.api.rest;

import org.rangiffler.model.FriendJson;
import org.rangiffler.model.UserJson;

import java.io.IOException;
import java.util.List;

public class UserdataRestClient extends BaseRestClient {

    public UserdataRestClient() {
        super(CFG.getUserdataUrl());
    }

    private final UserdataService userdataService = retrofit.create(UserdataService.class);

    public UserJson currentUser(String username) {
        try {
            return userdataService.currentUser(username).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UserJson addFriend(String username, String friendUsername) {
        try {
            FriendJson friendJson = new FriendJson();
            friendJson.setUsername(friendUsername);
            return userdataService.addFriend(username, friendJson).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserJson> acceptInvitation(String username, String inviteUsername) {
        try {
            FriendJson friendJson = new FriendJson();
            friendJson.setUsername(inviteUsername);
            return userdataService.acceptInvitation(username, friendJson).execute().body();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
