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
        public static final String COLUMN_NAME_FULLNAME = "full_name";
        public static final String COLUMN_NAME_PROFILE_PICTURE = "profile_picture";
        public static final String COLUMN_NAME_MEDIA_COUNT = "media_count";
        public static final String COLUMN_NAME_FOLLOWERS_COUNT = "followers_count";
        public static final String COLUMN_NAME_FOLLOWEDBY_COUNT = "followed_by_count";
    }

    public static abstract class MediaTable implements BaseColumns {
        //TODO: ADD OTHER INFORMATION
        public static final String TABLE_NAME = "media";
        public static final String COLUMN_NAME_ID = "id";
        public static final String COLUMN_NAME_TYPE = "type";
        public static final String COLUMN_NAME_TIME = "time";
        public static final String COLUMN_NAME_THUMBNAIL_IMAGE = "thumbnail_image";

    }
}
