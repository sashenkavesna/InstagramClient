package com.epam.androidlab.instagramclient.handlers;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.entity.Media;
import com.epam.androidlab.instagramclient.repository.MediaRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MediaResponseHandler implements ResponseHandler, Callback<Media> {
    private MediaRepository repo;

    public MediaResponseHandler() {
        repo = new MediaRepository();
    }

    @Override
    public void fetchResponse(String token) {
        Call<Media> call = ServerConnector.getAPI().getCurrentUsersRecentMedia(
                token,
                1,
                0,
                20
        );
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<Media> call, Response<Media> response) {
        if (response.isSuccessful()) {
            //  MediaResponse resp=response.body();
            Media media = response.body();
            repo.insertMedia(media);
            //// TODO: 29.06.2017 handle errors
        }
    }

    @Override
    public void onFailure(Call<Media> call, Throwable t) {

    }
}
