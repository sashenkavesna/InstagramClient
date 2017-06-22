package com.epam.androidlab.instagramclient;


import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    public static final String PREFERENCES = "Preferences";
    public static final String ACCESS_TOKEN = "Access token";
    private static final String USERNAME = "Username";
    private static final String ID = "Id";
    private static final String NAME = "Name";

    private SharedPreferences.Editor editor;
    private SharedPreferences sharedPref;


    public SessionManager(Context context) {
        sharedPref=
                context.getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public void storeAccessToken(String accessToken) {
        editor.putString(ACCESS_TOKEN, accessToken);
        editor.commit();
    }

    public void storeUsersInfo(String id, String username, String name) {
        editor.putString(ID, id);
        editor.putString(NAME, name);
        editor.putString(USERNAME, username);
        editor.commit();
    }

    public void reset() {
        editor.clear();
        editor.commit();
    }

    public String getAccessToken(){
        return sharedPref.getString(ACCESS_TOKEN,null);
    }
}
