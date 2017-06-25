package com.epam.androidlab.instagramclient.repository;


import com.epam.androidlab.instagramclient.data.User;

public interface SessionRepository {
    void insertResponseData(String accessToken, User user);
}
