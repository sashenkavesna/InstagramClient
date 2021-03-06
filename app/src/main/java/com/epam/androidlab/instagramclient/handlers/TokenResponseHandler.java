package com.epam.androidlab.instagramclient.handlers;


import com.epam.androidlab.instagramclient.Extras;
import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.repository.TokenDataRepository;
import com.epam.androidlab.instagramclient.responses.TokenResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TokenResponseHandler implements ResponseHandler, Callback<TokenResponse> {
    private TokenDataRepository repo;

    public TokenResponseHandler() {
        repo = new TokenDataRepository();
    }

    @Override
    public void fetchResponse(String token) {
        Call<TokenResponse> call = ServerConnector.getAPI().postSessionData(
                Extras.CLIENT_ID,
                Extras.CLIENT_SECRET,
                "authorization_code",
                Extras.CALLBACK_URL,
                token);
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<TokenResponse> call, Response<TokenResponse> response) {
        if (response.isSuccessful()) {
            TokenResponse resp = response.body();
            new TokenDataRepository().insertAccessToken(resp.getAccessToken());
            //  ServerConnector.getSessionManager().storeAccessToken();
            //// TODO: 26.06.2017 handle error 
        }
    }

    @Override
    public void onFailure(Call<TokenResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
