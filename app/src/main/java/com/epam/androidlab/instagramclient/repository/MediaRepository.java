package com.epam.androidlab.instagramclient.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.epam.androidlab.instagramclient.database.DBContract;
import com.epam.androidlab.instagramclient.entity.Images;
import com.epam.androidlab.instagramclient.entity.Media;
import com.epam.androidlab.instagramclient.entity.Thumbnail;

import java.util.ArrayList;

public class MediaRepository implements MediaDataRepository {
    //// TODO: 14.09.2017 update func
    private static boolean isEmpty = true;

    @Override
    public void insertMedia(Media media) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //Images images = media.getImages();

        values.put(DBContract.MediaTable.COLUMN_NAME_ID, media.getId());
        values.put(DBContract.MediaTable.COLUMN_NAME_TYPE, media.getType());
        values.put(DBContract.MediaTable.COLUMN_NAME_TIME, media.getTime());
        values.put(DBContract.MediaTable.COLUMN_NAME_THUMBNAIL_IMAGE,
                media.getImages().getTh().getUrl());

        long newRowId = db.insert(
                DBContract.MediaTable.TABLE_NAME,
                null,
                values);

        isEmpty = false;

    }

    @Override
    public void updateMedia(Media media) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(DBContract.MediaTable.COLUMN_NAME_ID, media.getId());
        values.put(DBContract.MediaTable.COLUMN_NAME_TYPE, media.getType());
        values.put(DBContract.MediaTable.COLUMN_NAME_TIME, media.getTime());
        values.put(DBContract.MediaTable.COLUMN_NAME_THUMBNAIL_IMAGE,
                media.getImages().getTh().getUrl());

        long newRowId = db.update(
                DBContract.UserTable.TABLE_NAME,
                values,
                DBContract.UserTable.COLUMN_NAME_ID + " = ?",
                new String[]{String.valueOf(media.getId())});
        db.close();
    }

    @Override
    public ArrayList<Media> readMedia() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        //todo return only image/function for likes comments etc
        Cursor cursor = db.query(
                DBContract.MediaTable.TABLE_NAME,          // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );
        ArrayList<Media> allMedia = new ArrayList<>();
        while (cursor.moveToNext()) {

            int typeIndex =
                    cursor.getColumnIndexOrThrow(
                            DBContract.MediaTable.COLUMN_NAME_TYPE
                    );
            int timeIndex =
                    cursor.getColumnIndexOrThrow(
                            DBContract.MediaTable.COLUMN_NAME_TIME
                    );
            int thImageIndex =
                    cursor.getColumnIndexOrThrow(
                            DBContract.MediaTable.COLUMN_NAME_THUMBNAIL_IMAGE
                    );

            int idIndex =
                    cursor.getColumnIndexOrThrow(
                            DBContract.MediaTable.COLUMN_NAME_ID
                    );

            Images images = new Images();
            Thumbnail th = new Thumbnail();
            String f = cursor.getString(thImageIndex);
            th.setUrl(f);
            images.setTh(th);

            String id = cursor.getString(idIndex);

            Media media = new Media();
            //  media.setId(cursor.getInt(idIndex));
            media.setType(cursor.getString(typeIndex));
            media.setTime(cursor.getString(timeIndex));
            media.setImages(images);
            media.setId(id);
            allMedia.add(media);
        }
        int k;

        k = 0;
        db.close();
        cursor.close();
        return allMedia;
    }

    @Override
    public boolean isEmpty() {
        return isEmpty;
    }
}
