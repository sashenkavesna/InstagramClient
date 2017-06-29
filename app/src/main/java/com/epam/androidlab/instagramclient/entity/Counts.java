package com.epam.androidlab.instagramclient.entity;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Counts implements Serializable {
    private String media;
    private String follows;

    @SerializedName("followed_by")
    private String followedBy;

    public String getFollowedBy() {
        return followedBy;
    }

    public String getFollows() {
        return follows;
    }

    public String getMedia() {
        return media;
    }

    public void setFollows(String follows) {
        this.follows = follows;
    }

    public void setFollowedBy(String followedBy) {
        this.followedBy = followedBy;
    }

    public void setMedia(String media) {
        this.media = media;
    }
}