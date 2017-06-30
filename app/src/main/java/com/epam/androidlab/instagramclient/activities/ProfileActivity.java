package com.epam.androidlab.instagramclient.activities;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.epam.androidlab.instagramclient.R;
import com.epam.androidlab.instagramclient.fragments.UserInfoFragment;
import com.epam.androidlab.instagramclient.presenters.UserDataPresenter;

public class ProfileActivity extends AppCompatActivity {
    // private static final String TAG_USER_INFO_FRAGMENT="user info fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
       /* getFragmentManager()
                .beginTransaction()
                .add(R.id.activity_profile_layout,new UserInfoFragment(), TAG_USER_INFO_FRAGMENT)
                .commit();*/
        UserInfoFragment userInfoFragment =
                (UserInfoFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.user_info_fragment);
        UserDataPresenter presenter = new UserDataPresenter(userInfoFragment);
        presenter.onCreate();
    }
}
