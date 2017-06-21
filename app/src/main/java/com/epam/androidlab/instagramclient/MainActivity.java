package com.epam.androidlab.instagramclient;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private SessionManager sessionManager;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // if (requestCode == PICK_CONTACT_REQUEST) {
        if (resultCode == RESULT_OK) {
            ServerConnector serverConnector = new ServerConnector();
            serverConnector.getSessionData(data.getStringExtra("Code for access token"));
            sessionManager.storeAccessToken(data.getStringExtra("Code for access token"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && !activeNetwork.isConnected()) {
            Toast.makeText(this, getString(R.string.no_internet), Toast.LENGTH_SHORT).show();
        }
        sessionManager = new SessionManager(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
     //   if (sessionManager.getAccessToken() == null) {
            startActivityForResult(new Intent(this, AuthorizationActivity.class), 1);
       /* } else {
            startActivity(new Intent(this, ProfileActivity.class));
        }*/
    }

}
