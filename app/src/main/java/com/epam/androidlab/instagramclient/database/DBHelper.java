package com.epam.androidlab.instagramclient.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "InstaClient.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String SQL_CREATE_USER_TABLE =
            "CREATE TABLE" + DBContract.UserTable.TABLE_NAME + " (" +
                    DBContract.UserTable.COLUMN_NAME_ID + " INTEGER PRIMARY KEY," +
                    DBContract.UserTable.COLUMN_NAME_USERNAME + TEXT_TYPE + "," +
                    DBContract.UserTable.COLUMN_NAME_FULLNAME + TEXT_TYPE + "," +
                    DBContract.UserTable.COLUMN_NAME_PROFILE_PICTURE + TEXT_TYPE +
                    " )";
    private static final String SQL_DELETE_USER =
            "DROP TABLE IF EXISTS " + DBContract.UserTable.TABLE_NAME;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_USER);
        onCreate(db);
    }
}
