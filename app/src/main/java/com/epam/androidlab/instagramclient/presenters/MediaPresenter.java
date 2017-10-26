package com.epam.androidlab.instagramclient.presenters;


import com.epam.androidlab.instagramclient.asynctasks.MediaReaderTask;
import com.epam.androidlab.instagramclient.entity.Media;
import com.epam.androidlab.instagramclient.fragments.MediaFragment;
import com.epam.androidlab.instagramclient.handlers.MediaResponseHandler;
import com.epam.androidlab.instagramclient.repository.TokenDataRepository;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MediaPresenter implements ProfilePresenter {
    private MediaResponseHandler handler = new MediaResponseHandler();
    private MediaFragment fragment;

    public MediaPresenter(MediaFragment fragment) {
        this.fragment = fragment;
    }

    public MediaPresenter() {
    }

    @Override
    public void onUpdateActivity() {
        handler.fetchResponse(new TokenDataRepository().readAccessToken());
    }

    @Override
    public void onCreateProfileActivity() {
        MediaReaderTask task = new MediaReaderTask();
        task.execute();
        ArrayList<Media> mediaList = new ArrayList<>();
        try {
            mediaList = task.get();
            //  response.setMedia(media);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        ArrayList<String> imgUrls = new ArrayList<>();
        for (Media media : mediaList) {
            imgUrls.add(media.getImages().getTh().getUrl());
        }
        fragment.update(imgUrls);
    }
}
