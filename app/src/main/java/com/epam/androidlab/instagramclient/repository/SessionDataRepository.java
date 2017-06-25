package com.epam.androidlab.instagramclient.repository;


import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.data.User;
import com.epam.androidlab.instagramclient.database.DBContract;
import com.epam.androidlab.instagramclient.database.DBHelper;

public class SessionDataRepository implements SessionRepository {
    private DBHelper dbHelper;

    public SessionDataRepository(DBHelper dbHelper) {
        this.dbHelper = dbHelper;
    }

    @Override
    public void insertResponseData(String accessToken, User user) {
        insertAccessToken(accessToken);
        insertUser(user);
    }

    private void insertAccessToken(String token) {
        ServerConnector.getSessionManager().storeAccessToken(token);
    }

    private void insertUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBContract.UserTable.COLUMN_NAME_ID, user.getId());
        values.put(DBContract.UserTable.COLUMN_NAME_USERNAME, user.getUserName());
        values.put(DBContract.UserTable.COLUMN_NAME_FULLNAME, user.getFullName());
        values.put(DBContract.UserTable.COLUMN_NAME_PROFILE_PICTURE, user.getProfilePicture());

        long newRowId = db.insert(
                DBContract.UserTable.TABLE_NAME,
                null,
                values);
    }
}
