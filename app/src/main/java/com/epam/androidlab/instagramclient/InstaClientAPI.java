package com.epam.androidlab.instagramclient;


import com.epam.androidlab.instagramclient.entity.User;
import com.epam.androidlab.instagramclient.entity.responses.MediaResponse;
import com.epam.androidlab.instagramclient.entity.responses.RelationshipResponse;
import com.epam.androidlab.instagramclient.entity.responses.TokenResponse;
import com.epam.androidlab.instagramclient.entity.responses.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface InstaClientAPI {

    @FormUrlEncoded
    @POST("oauth/access_token")
    Call<TokenResponse> postSessionData(
            @Field("client_id") String clientId,
            @Field("client_secret") String clientSecret,
            @Field("grant_type") String authCode,
            @Field("redirect_uri") String callbackUrl,
            @Field("code") String codeForToken
    );

    @GET("v1/users/self/media/recent")
    Call<MediaResponse> getCurrentUsersRecentMedia(
            @Query("access_token") String accessToken,
            @Query("max_id") int maxId,
            @Query("min_id") int minId,
            @Query("count") int countOfMedia
    );

    @GET("v1/users/self/")
    Call<UserResponse> getCurrentUser(
            @Query("access_token") String accessToken
    );

    @GET("v1/users/self/follows")
    Call<List<User>> getCurrentUsersFollows(
            @Query("access_token") String accessToken
    );

    @GET("v1/users/self/followed-by")
    Call<List<User>> getCurrentUserFollowedBy(
            @Query("access_token") String accessToken
    );

    @GET("/users/self/requested-by")
    Call<List<User>> getCurrentUserRequestedBy(
            @Query("access_token") String accessToken
    );

    @FormUrlEncoded
    @POST("v1/users/{user-id}/relationship")
    Call<RelationshipResponse> postRelationshipWithUser(
            @Path("{user-id}") int userId,
            @Field("access_token") String acessToken,
            @Field("action") String action
    );
}
