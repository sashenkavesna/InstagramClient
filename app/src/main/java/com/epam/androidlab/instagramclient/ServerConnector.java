package com.epam.androidlab.instagramclient;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerConnector {
    private InstaClientAPI client;

    public ServerConnector()  {
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Extras.API_URL)
                .addConverterFactory(GsonConverterFactory.create()
                );

        Retrofit retrofit = builder.client(httpClient.build())
                .build();

        client = retrofit.create(InstaClientAPI.class);
    }

    public void getSessionData(String codeForToken) {
        Call<SessionResponse> call = client.postSessionData(
                Extras.CLIENT_ID,
                Extras.CLIENT_SECRET,
                "authorization_code",
                Extras.CALLBACK_URL,
                codeForToken);
        call.enqueue(new Callback<SessionResponse>() {
            @Override
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                if (response.isSuccessful()) {
                    SessionResponse resp=response.body();
                    String accessToken=resp.getAccessToken();
                    User user=resp.getUser();
                }
            }

            @Override
            public void onFailure(Call<SessionResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
