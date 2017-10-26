package com.epam.androidlab.instagramclient.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.epam.androidlab.instagramclient.Extras;
import com.epam.androidlab.instagramclient.R;
import com.epam.androidlab.instagramclient.presenters.MediaPresenter;
import com.epam.androidlab.instagramclient.presenters.TokenManager;
import com.epam.androidlab.instagramclient.presenters.UserInfoPresenter;
import com.epam.androidlab.instagramclient.repository.TokenDataRepository;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if (requestCode == PICK_CONTACT_REQUEST) {
        if (resultCode == RESULT_OK) {
            String code = data.getStringExtra(Extras.TOKEN_CODE_KEY);
            new TokenManager().onActivityResult(code);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        String token = new TokenDataRepository().readAccessToken();
        if (token == null) {
            startActivityForResult(new Intent(this, AuthorizationActivity.class), 1);
        } else {
            new UserInfoPresenter().onUpdateActivity();
            new MediaPresenter().onUpdateActivity();
            startActivity(new Intent(this, ProfileActivity.class));
        }
        // finish();
    }
}
