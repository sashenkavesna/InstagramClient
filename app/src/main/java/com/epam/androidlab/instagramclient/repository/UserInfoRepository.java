package com.epam.androidlab.instagramclient.repository;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.epam.androidlab.instagramclient.database.DBContract;
import com.epam.androidlab.instagramclient.entity.Counts;
import com.epam.androidlab.instagramclient.entity.User;

public class UserInfoRepository implements UserRepository {
    private static boolean isEmpty = true;

    @Override
    public void insertUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
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
        db.close();
        isEmpty = false;
    }

    @Override
    public void updateUser(User user) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        Counts counts = user.getCounts();

        values.put(DBContract.UserTable.COLUMN_NAME_ID, user.getId());
        values.put(DBContract.UserTable.COLUMN_NAME_USERNAME, user.getUserName());
        values.put(DBContract.UserTable.COLUMN_NAME_FULLNAME, user.getFullName());
        values.put(DBContract.UserTable.COLUMN_NAME_PROFILE_PICTURE, user.getProfilePicture());
        values.put(DBContract.UserTable.COLUMN_NAME_MEDIA_COUNT, counts.getMedia());
        values.put(DBContract.UserTable.COLUMN_NAME_FOLLOWERS_COUNT, counts.getFollows());
        values.put(DBContract.UserTable.COLUMN_NAME_FOLLOWEDBY_COUNT, counts.getFollowedBy());

        long newRowId = db.update(
                DBContract.UserTable.TABLE_NAME,
                values,
                DBContract.UserTable.COLUMN_NAME_ID + " = ?",
                new String[]{String.valueOf(user.getId())});
        db.close();
    }

    @Override
    public User readUser() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();


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

        User user = new User();

        if (cursor.moveToFirst()) {

            int idIndex =
                    cursor.getColumnIndexOrThrow(
                            DBContract.UserTable.COLUMN_NAME_ID
                    );

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

            user.setUserName(cursor.getString(userNameIndex));
            user.setProfilePicture(cursor.getString(profilePictureIndex));
            user.setCounts(counts);
            user.setId(cursor.getString(idIndex));
        }

        db.close();
        cursor.close();

        return user;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }
}
