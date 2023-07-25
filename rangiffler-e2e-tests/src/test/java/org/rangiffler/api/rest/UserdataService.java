package org.rangiffler.api.rest;

import org.rangiffler.model.FriendJson;
import org.rangiffler.model.UserJson;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

import java.util.List;

public interface UserdataService {

    @GET("/currentUser")
    Call<UserJson> currentUser(
            @Query("username") String username
    );

    @POST("/addFriend")
    Call<UserJson> addFriend(
            @Query("username") String username,
            @Body FriendJson friendJson);

    @POST("/acceptInvitation")
    Call<List<UserJson>> acceptInvitation(
            @Query("username") String username,
            @Body FriendJson friendJson);
}
