package com.epam.androidlab.instagramclient.entity;


import com.google.gson.annotations.SerializedName;

public class User {
    //TODO ADD OTHER INFO
    @SerializedName("full_name")
    private  String fullName;

    @SerializedName("username")
    private String userName;

    @SerializedName("profile_picture")
    private String profilePicture;

    private int id;

    @SerializedName("counts")
    private Counts counts;

    //225026122.1fc92e9.148705116a6f479ea8039c75992e643d
    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public Counts getCounts() {
        return counts;
    }

    public void setCounts(Counts counts) {
        this.counts = counts;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}

