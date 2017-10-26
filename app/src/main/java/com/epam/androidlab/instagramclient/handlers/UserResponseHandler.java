package com.epam.androidlab.instagramclient.handlers;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.repository.UserInfoRepository;
import com.epam.androidlab.instagramclient.responses.UserResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserResponseHandler implements ResponseHandler, Callback<UserResponse> {

    @Override
    public void fetchResponse(String token) {
        Call<UserResponse> call = ServerConnector.getAPI().getCurrentUser(token);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
        if (response.isSuccessful()) {
            UserResponse resp = response.body();
            UserInfoRepository repo = new UserInfoRepository();
            if (repo.isEmpty()) {
                repo.insertUser(resp.getUser());
            } else {
                repo.updateUser(resp.getUser());
            }
            //// TODO: 26.06.2017 handle error
        }
    }

    @Override
    public void onFailure(Call<UserResponse> call, Throwable t) {

    }

}
