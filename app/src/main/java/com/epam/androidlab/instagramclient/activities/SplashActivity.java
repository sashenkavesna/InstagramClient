package com.epam.androidlab.instagramclient.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.epam.androidlab.instagramclient.R;
import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.handlers.TokenResponseHandler;

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
            //  TokenDataRepository repo = new TokenDataRepository();
            TokenResponseHandler manager = new TokenResponseHandler();
            String code = data.getStringExtra("Code for access token");
            manager.fetchResponse(code);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        String token = ServerConnector.getSessionManager().getAccessToken();
        if (token == null) {
            startActivityForResult(new Intent(this, AuthorizationActivity.class), 1);
        } else {
            startActivity(new Intent(this, ProfileActivity.class));
        }
        // finish();
    }
}
