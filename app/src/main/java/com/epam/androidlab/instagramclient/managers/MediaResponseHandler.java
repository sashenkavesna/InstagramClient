package com.epam.androidlab.instagramclient.managers;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.entity.responses.MediaResponse;
import com.epam.androidlab.instagramclient.repository.MediaRepository;

import retrofit2.Call;

public class MediaResponseHandler implements ResponseHandler {
    private MediaRepository repo;

    public MediaResponseHandler() {
        repo = new MediaRepository();
    }

    @Override
    public void fetchResponse(String token) {
        Call<MediaResponse> call = ServerConnector.getAPI().getCurrentUsersRecentMedia(
                token,
                1,
                0,
                20
        );
        //  call.enqueue();
    }
}
