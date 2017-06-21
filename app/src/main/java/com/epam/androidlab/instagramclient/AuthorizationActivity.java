package com.epam.androidlab.instagramclient;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

//// TODO: 20.06.2017 add fragment for activity 
public class AuthorizationActivity extends AppCompatActivity {
    private Activity context;

    @Override
    public void onBackPressed() {
        //// TODO: 20.06.2017 finish all activities 
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        context = this;
        WebView webView = (WebView) findViewById(R.id.insta_auth_view);
        webView.setWebViewClient(new AuthorizationClient());
        //// TODO: 20.06.2017 split url 
        webView.loadUrl("https://api.instagram.com/oauth/authorize/?client_id=1fc92e9a1b6c4e46bafb02b5652386b7&redirect_uri=http://localhost&response_type=code");
    }

    private class AuthorizationClient extends WebViewClient {

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            if (url.startsWith(Extras.CALLBACK_URL)) {
                String answer[] = url.split("=");   
                //// TODO: 20.06.2017 handle errors 
                Intent intent = new Intent();
                //// TODO: 20.06.2017 variable for key 
                intent.putExtra("Code for access token", answer[1]);
                setResult(RESULT_OK, intent);
                context.finish();
            }
        }

    }
}
