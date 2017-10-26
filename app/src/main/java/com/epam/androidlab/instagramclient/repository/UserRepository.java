package com.epam.androidlab.instagramclient.repository;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.database.DBHelper;
import com.epam.androidlab.instagramclient.entity.User;

public interface UserRepository {
    DBHelper dbHelper = ServerConnector.getDbHelper();
    void insertUser(User user);

    void updateUser(User user);
    User readUser();

    boolean isEmpty();
}
