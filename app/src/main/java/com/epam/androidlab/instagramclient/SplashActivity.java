package com.epam.androidlab.instagramclient;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

public class SplashActivity extends AppCompatActivity {
    private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        sessionManager = new SessionManager(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if (requestCode == PICK_CONTACT_REQUEST) {
        if (resultCode == RESULT_OK) {
            //serverConnector.getSessionData(data.getStringExtra("Code for access token"));
            sessionManager.storeAccessToken(data.getStringExtra("Code for access token"));
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (sessionManager.getAccessToken() == null) {
            startActivityForResult(new Intent(this, AuthorizationActivity.class), 1);
        } else {
            startActivity(new Intent(this, ProfileActivity.class));
        }
        finish();
    }
}
