package com.epam.androidlab.instagramclient.handlers;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.entity.responses.UserResponse;
import com.epam.androidlab.instagramclient.repository.UserInfoRepository;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserResponseHandler implements ResponseHandler, Callback<UserResponse> {
    private UserInfoRepository repo;

    public UserResponseHandler() {
        repo = new UserInfoRepository();
    }

    @Override
    public void fetchResponse(String token) {
        Call<UserResponse> call = ServerConnector.getAPI().getCurrentUser(token);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
        if (response.isSuccessful()) {
            UserResponse resp = response.body();
            // repo.insertAccessToken(resp.getAccessToken());

            repo.insertUser(resp.getUser());
            //// TODO: 26.06.2017 handle error
        }
    }

    @Override
    public void onFailure(Call<UserResponse> call, Throwable t) {

    }

}
