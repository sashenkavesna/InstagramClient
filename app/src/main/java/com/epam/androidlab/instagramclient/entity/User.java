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

    private String id;

    @SerializedName("counts")
    private Counts counts;

    public String getFullName() {
        return fullName;
    }

    public String getId() {
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

    public void setId(String id) {
        this.id = id;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public class Position {
        int x;
        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

}

