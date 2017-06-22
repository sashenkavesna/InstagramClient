package com.epam.androidlab.instagramclient;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServerConnector extends Application {
    private static ServerConnector serverConnector;
    private static InstaClientAPI clientAPI;

    @Override
    public void onCreate() {
        super.onCreate();
        serverConnector = this;
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(Extras.API_URL)
                .addConverterFactory(GsonConverterFactory.create()
                );
        Retrofit retrofit = builder.client(httpClient.build())
                .build();
        clientAPI = retrofit.create(InstaClientAPI.class);
    }


    public void checkConnection() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && !activeNetwork.isConnected()) {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
        }
    }

    public static ServerConnector getInstance() {
        return serverConnector;
    }

    public static InstaClientAPI getAPI() {
        return clientAPI;
    }

    public void getSessionData(String codeForToken) {
        Call<SessionResponse> call = clientAPI.postSessionData(
                Extras.CLIENT_ID,
                Extras.CLIENT_SECRET,
                "authorization_code",
                Extras.CALLBACK_URL,
                codeForToken);
        call.enqueue(new Callback<SessionResponse>() {
            @Override
            public void onResponse(Call<SessionResponse> call, Response<SessionResponse> response) {
                if (response.isSuccessful()) {
                    SessionResponse resp = response.body();
                    String accessToken = resp.getAccessToken();
                    User user = resp.getUser();
                }
            }

            @Override
            public void onFailure(Call<SessionResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
