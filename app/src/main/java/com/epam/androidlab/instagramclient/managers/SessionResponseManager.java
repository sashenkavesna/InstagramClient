package com.epam.androidlab.instagramclient.managers;


import com.epam.androidlab.instagramclient.Extras;
import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.repository.SessionDataRepository;
import com.epam.androidlab.instagramclient.responses.SessionResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SessionResponseManager implements ResponseHandler, Callback<SessionResponse> {
    private SessionDataRepository repo;

    public SessionResponseManager(SessionDataRepository repo) {
        this.repo = repo;
    }

    @Override
    public void fetchResponse(String codeForToken) {
        Call<SessionResponse> call = ServerConnector.getAPI().postSessionData(
                Extras.CLIENT_ID,
                Extras.CLIENT_SECRET,
                "authorization_code",
                Extras.CALLBACK_URL,
                codeForToken);
        call.enqueue(this);
    }

    @Override
    public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
        if (response.isSuccessful()) {
            SessionResponse resp = response.body();
            repo.insertResponseData(resp.getAccessToken(), resp.getUser());
        }
    }

    @Override
    public void onFailure(Call<SessionResponse> call, Throwable t) {
        t.printStackTrace();
    }
}
