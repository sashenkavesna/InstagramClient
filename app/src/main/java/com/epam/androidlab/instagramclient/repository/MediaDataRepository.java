package com.epam.androidlab.instagramclient.repository;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.database.DBHelper;
import com.epam.androidlab.instagramclient.entity.Media;

public interface MediaDataRepository {
    DBHelper dbHelper = ServerConnector.getDbHelper();

    void insertMedia(Media media);

    Media readMedia();
}
