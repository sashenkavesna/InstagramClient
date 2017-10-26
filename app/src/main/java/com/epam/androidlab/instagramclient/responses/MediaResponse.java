package com.epam.androidlab.instagramclient.responses;


import com.epam.androidlab.instagramclient.entity.Media;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MediaResponse {
    @SerializedName("data")
    private ArrayList<Media> media;

    public ArrayList<Media> getMedia() {
        return media;
    }

    public void setMedia(ArrayList<Media> media) {
        this.media = media;
    }
}
