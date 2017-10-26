package com.epam.androidlab.instagramclient.repository;


import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.database.DBHelper;
import com.epam.androidlab.instagramclient.entity.Media;

import java.util.ArrayList;

public interface MediaDataRepository {
    DBHelper dbHelper = ServerConnector.getDbHelper();

    void insertMedia(Media media);

    void updateMedia(Media media);

    ArrayList<Media> readMedia();

    boolean isEmpty();
}
