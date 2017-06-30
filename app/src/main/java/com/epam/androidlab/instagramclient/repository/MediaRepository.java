package com.epam.androidlab.instagramclient.repository;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.epam.androidlab.instagramclient.database.DBContract;
import com.epam.androidlab.instagramclient.entity.Images;
import com.epam.androidlab.instagramclient.entity.Media;
import com.epam.androidlab.instagramclient.entity.Thumbnail;

public class MediaRepository implements MediaDataRepository {

    @Override
    public void insertMedia(Media media) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        Images images = media.getImages();

        values.put(DBContract.MediaTable.COLUMN_NAME_ID, media.getId());
        values.put(DBContract.MediaTable.COLUMN_NAME_TYPE, media.getType());
        values.put(DBContract.MediaTable.COLUMN_NAME_TIME, media.getTime());
        values.put(DBContract.MediaTable.COLUMN_NAME_THUMBNAIL_IMAGE,
                media.getImages().getTh().getUrl());

        long newRowId = db.insert(
                DBContract.MediaTable.TABLE_NAME,
                null,
                values);
    }

    @Override
    public Media readMedia() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        Cursor cursor = db.query(
                DBContract.MediaTable.TABLE_NAME,          // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        cursor.moveToFirst();

        int idIndex =
                cursor.getColumnIndexOrThrow(
                        DBContract.MediaTable.COLUMN_NAME_ID
                );
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
        Images images = new Images();
        Thumbnail th = new Thumbnail();
        th.setUrl(cursor.getString(thImageIndex));
        images.setTh(th);

        Media media = new Media();
        media.setId(cursor.getInt(idIndex));
        media.setType(cursor.getString(typeIndex));
        media.setTime(cursor.getString(timeIndex));
        media.setImages(images);

        return media;
    }
}
