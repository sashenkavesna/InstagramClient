package com.epam.androidlab.instagramclient.responses;


import com.epam.androidlab.instagramclient.entity.User;
import com.google.gson.annotations.SerializedName;

public class UserResponse {
    @SerializedName("data")
    private User user;

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
