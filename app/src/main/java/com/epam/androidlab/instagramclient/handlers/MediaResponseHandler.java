package com.epam.androidlab.instagramclient.handlers;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.entity.Media;
import com.epam.androidlab.instagramclient.repository.MediaRepository;
import com.epam.androidlab.instagramclient.responses.MediaResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MediaResponseHandler implements ResponseHandler, Callback<MediaResponse> {

    @Override
    public void fetchResponse(String token) {
        Call<MediaResponse> call = ServerConnector.getAPI().getCurrentUsersRecentMedia(token);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<MediaResponse> call, Response<MediaResponse> response) {
        if (response.isSuccessful()) {
            //update func
            MediaResponse resp = response.body();
            MediaRepository repo = new MediaRepository();
            for (Media media : resp.getMedia()) {
                if (repo.isEmpty()) {
                    repo.insertMedia(media);
                } else {
                    repo.updateMedia(media);
                }
            }
            int k;
            k = 0;
            //  setMedia(resp);


            //// TODO: 29.06.2017 handle errors
        }
    }


    @Override
    public void onFailure(Call<MediaResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
