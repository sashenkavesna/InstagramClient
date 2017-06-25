package com.epam.androidlab.instagramclient.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import com.epam.androidlab.instagramclient.R;
import com.epam.androidlab.instagramclient.ServerConnector;
import com.epam.androidlab.instagramclient.database.DBHelper;
import com.epam.androidlab.instagramclient.managers.SessionResponseManager;
import com.epam.androidlab.instagramclient.repository.SessionDataRepository;

public class SplashActivity extends AppCompatActivity {
    //  private SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ProgressBar progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(ProgressBar.VISIBLE);

        // sessionManager = new SessionManager(this);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if (requestCode == PICK_CONTACT_REQUEST) {
        if (resultCode == RESULT_OK) {
            DBHelper dbHelper = new DBHelper(this);
            SessionDataRepository repo = new SessionDataRepository(dbHelper);
            SessionResponseManager manager = new SessionResponseManager(repo);
            String code = data.getStringExtra("Code for access token");
            manager.fetchResponse(code);

            // rep.
            //      sessionManager.storeAccessToken(response.getAccessToken());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (ServerConnector.getSessionManager().getAccessToken() == null) {
            startActivityForResult(new Intent(this, AuthorizationActivity.class), 1);
        } else {
            startActivity(new Intent(this, ProfileActivity.class));
        }
        // finish();
    }
}
