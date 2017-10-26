package com.epam.androidlab.instagramclient.asynctasks;


import android.os.AsyncTask;

import com.epam.androidlab.instagramclient.entity.Media;
import com.epam.androidlab.instagramclient.repository.MediaRepository;

import java.util.ArrayList;

public class MediaReaderTask extends AsyncTask<Void, Void, ArrayList<Media>> {
    @Override
    protected ArrayList<Media> doInBackground(Void... params) {
        MediaRepository repo = new MediaRepository();
        ArrayList<Media> media = repo.readMedia();
        return media;
    }
}
