package com.epam.androidlab.instagramclient.repository;


import com.epam.androidlab.instagramclient.entity.User;

public interface UserRepository {
    void insertUser(User user);

    User readUser();
}
