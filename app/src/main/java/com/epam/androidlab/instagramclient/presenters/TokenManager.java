package com.epam.androidlab.instagramclient.presenters;


import com.epam.androidlab.instagramclient.handlers.TokenResponseHandler;

public class TokenManager implements TokenPresenter {
    @Override
    public void onActivityResult(String code) {
        TokenResponseHandler handler = new TokenResponseHandler();
        handler.fetchResponse(code);
    }
}
