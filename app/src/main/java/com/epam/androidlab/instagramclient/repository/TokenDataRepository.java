package com.epam.androidlab.instagramclient.repository;


import com.epam.androidlab.instagramclient.ServerConnector;

public class TokenDataRepository implements SessionRepository {


    @Override
    public void insertAccessToken(String token) {
        ServerConnector.getSessionManager().storeAccessToken(token);
    }

    @Override
    public String readAccessToken() {
        return ServerConnector.getSessionManager().getAccessToken();
    }

}
