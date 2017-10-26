package com.epam.androidlab.instagramclient.activities;


import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;

import com.epam.androidlab.instagramclient.R;
import com.epam.androidlab.instagramclient.fragments.MediaFragment;
import com.epam.androidlab.instagramclient.fragments.UserInfoFragment;
import com.epam.androidlab.instagramclient.presenters.MediaPresenter;
import com.epam.androidlab.instagramclient.presenters.UserInfoPresenter;

public class ProfileActivity extends AppCompatActivity {
    // private static final String TAG_USER_INFO_FRAGMENT="user info fragment";

    private UserInfoPresenter userInfoPresenter;
    private MediaPresenter mediaPresenter;

    private SwipeRefreshLayout swipeRefreshLayout;

    SwipeRefreshLayout.OnRefreshListener refreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            userInfoPresenter.onUpdateActivity();
            mediaPresenter.onUpdateActivity();
            //// TODO: 14.09.2017 add func for this 
            userInfoPresenter.onCreateProfileActivity();
            mediaPresenter.onCreateProfileActivity();
            //// TODO: 14.09.2017 fix anim 
            swipeRefreshLayout.setRefreshing(false);
        }
    };

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
        MediaFragment mediaFragment =
                (MediaFragment) getSupportFragmentManager()
                        .findFragmentById(R.id.media_fragment);

        userInfoPresenter = new UserInfoPresenter(userInfoFragment);
        mediaPresenter = new MediaPresenter(mediaFragment);

        userInfoPresenter.onCreateProfileActivity();
        mediaPresenter.onCreateProfileActivity();

        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swiperefresh);
        swipeRefreshLayout.setOnRefreshListener(refreshListener);

    }
}
