package com.epam.androidlab.instagramclient;


import com.google.gson.annotations.SerializedName;

public class User {
//    private ArrayList<Media> publications;

  //  private ArrayList<User> followers;
    //private ArrayList<User> following;

    private int id;
    @SerializedName("full_name")
    private  String fullName;
    private String username;
    private String bio;
    @SerializedName("profile_picture")
    private String profilePicture;


    public String getBio() {
        return bio;
    }

    public String getFullName() {
        return fullName;
    }

    public int getId() {
        return id;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public String getUsername() {
        return username;
    }
}
