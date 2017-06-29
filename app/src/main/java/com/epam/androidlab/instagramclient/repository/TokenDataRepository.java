package com.epam.androidlab.instagramclient.repository;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.database.DBHelper;

public class TokenDataRepository implements SessionRepository {
    private DBHelper dbHelper = ServerConnector.getDbHelper();

    @Override
    public void insertAccessToken(String token) {
        ServerConnector.getSessionManager().storeAccessToken(token);
    }

    @Override
    public String readAccessToken() {
        return ServerConnector.getSessionManager().getAccessToken();
    }


}
