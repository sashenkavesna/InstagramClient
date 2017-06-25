package com.epam.androidlab.instagramclient.database;

import android.provider.BaseColumns;

public final class DBContract {
    public DBContract() {
    }

    public static abstract class UserTable implements BaseColumns {
        //TODO: ADD OTHER INFORMATION
        public static final String TABLE_NAME = "user";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_USERNAME = "name";
        public static final String COLUMN_NAME_FULLNAME = "full name";
        public static final String COLUMN_NAME_PROFILE_PICTURE = "profile picture";
    }
}
