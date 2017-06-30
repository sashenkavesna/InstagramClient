package com.epam.androidlab.instagramclient.asynctasks;


import android.os.AsyncTask;

import com.epam.androidlab.instagramclient.entity.Media;
import com.epam.androidlab.instagramclient.repository.MediaRepository;

public class MediaReaderTask extends AsyncTask<Void, Void, Media> {
    @Override
    protected Media doInBackground(Void... params) {
        MediaRepository repo = new MediaRepository();
        Media media = repo.readMedia();
        return media;
    }
}
