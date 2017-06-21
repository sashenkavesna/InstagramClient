package com.epam.androidlab.instagramclient;


import com.google.gson.annotations.SerializedName;

public class SessionResponse {
    @SerializedName("access_token")
    private String accessToken;

    private User user;

    public String getAccessToken() {
        return accessToken;
    }

    public User getUser() {
        return user;
    }
}
