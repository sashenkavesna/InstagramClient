package com.epam.androidlab.instagramclient.responses;


import com.epam.androidlab.instagramclient.data.User;
import com.google.gson.annotations.SerializedName;

public class SessionResponse {
    @SerializedName("access_token")
    private String accessToken;
    private User user;

    public SessionResponse() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public User getUser() {
        return user;
    }

}
