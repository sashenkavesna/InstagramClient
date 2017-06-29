package com.epam.androidlab.instagramclient.repository;


public interface SessionRepository {
    void insertAccessToken(String accessToken);

    String readAccessToken();
}
