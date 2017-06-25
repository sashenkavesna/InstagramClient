package com.epam.androidlab.instagramclient.data;


import com.google.gson.annotations.SerializedName;

public class User {

//    private ArrayList<Media> publications;

  //  private ArrayList<User> followers;
    //private ArrayList<User> following;

    //TODO ADD OTHER INFO
    private int id;
    @SerializedName("full_name")
    private  String fullName;
    @SerializedName("username")
    private String userName;
    @SerializedName("profile_picture")
    private String profilePicture;


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
}
