package com.epam.androidlab.instagramclient.repository;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.database.DBContract;
import com.epam.androidlab.instagramclient.database.DBHelper;
import com.epam.androidlab.instagramclient.entity.Counts;
import com.epam.androidlab.instagramclient.entity.User;

public class UserInfoRepository implements UserRepository {
    private SQLiteDatabase db;

    public UserInfoRepository() {
        DBHelper dbHelper = ServerConnector.getDbHelper();
        db = dbHelper.getReadableDatabase();
    }

    @Override
    public void insertUser(User user) {
        ContentValues values = new ContentValues();
        Counts counts = user.getCounts();

        values.put(DBContract.UserTable.COLUMN_NAME_ID, user.getId());
        values.put(DBContract.UserTable.COLUMN_NAME_USERNAME, user.getUserName());
        values.put(DBContract.UserTable.COLUMN_NAME_FULLNAME, user.getFullName());
        values.put(DBContract.UserTable.COLUMN_NAME_PROFILE_PICTURE, user.getProfilePicture());
        values.put(DBContract.UserTable.COLUMN_NAME_MEDIA_COUNT, counts.getMedia());
        values.put(DBContract.UserTable.COLUMN_NAME_FOLLOWERS_COUNT, counts.getFollows());
        values.put(DBContract.UserTable.COLUMN_NAME_FOLLOWEDBY_COUNT, counts.getFollowedBy());

        long newRowId = db.insert(
                DBContract.UserTable.TABLE_NAME,
                null,
                values);

    }

    @Override
    public User readUser() {


      /*  String[] projection = {
                DBContract.UserTable.COLUMN_NAME_USERNAME,
                DBContract.UserTable.COLUMN_NAME_MEDIA_COUNT,
                DBContract.UserTable.COLUMN_NAME_FOLLOWERS_COUNT,
                DBContract.UserTable.COLUMN_NAME_FOLLOWEDBY_COUNT,
                DBContract.UserTable.COLUMN_NAME_PROFILE_PICTURE
        };*/
        //  String sortOrder = FeedEntry.COLUMN_NAME_UPDATED + " DESC";

        Cursor cursor = db.query(
                DBContract.UserTable.TABLE_NAME,          // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        cursor.moveToFirst();

        int userNameIndex =
                cursor.getColumnIndexOrThrow(
                        DBContract.UserTable.COLUMN_NAME_USERNAME
                );
        int mediaCountIndex =
                cursor.getColumnIndexOrThrow(
                        DBContract.UserTable.COLUMN_NAME_MEDIA_COUNT
                );
        int followersCountIndex =
                cursor.getColumnIndexOrThrow(
                        DBContract.UserTable.COLUMN_NAME_FOLLOWERS_COUNT
                );
        int followedByCountIndex =
                cursor.getColumnIndexOrThrow(
                        DBContract.UserTable.COLUMN_NAME_FOLLOWEDBY_COUNT
                );
        int profilePictureIndex =
                cursor.getColumnIndexOrThrow(
                        DBContract.UserTable.COLUMN_NAME_PROFILE_PICTURE
                );

        Counts counts = new Counts();
        counts.setMedia(cursor.getString(mediaCountIndex));
        counts.setFollows(cursor.getString(followersCountIndex));
        counts.setFollowedBy(cursor.getString(followedByCountIndex));

        User user = new User();
        user.setUserName(cursor.getString(userNameIndex));
        user.setProfilePicture(cursor.getString(profilePictureIndex));
        user.setCounts(counts);

        return user;
    }
}
