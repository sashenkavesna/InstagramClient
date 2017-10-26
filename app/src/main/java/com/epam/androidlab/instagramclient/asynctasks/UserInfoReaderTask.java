package com.epam.androidlab.instagramclient.asynctasks;


import android.os.AsyncTask;

import com.epam.androidlab.instagramclient.entity.User;
import com.epam.androidlab.instagramclient.repository.UserInfoRepository;

public class UserInfoReaderTask extends AsyncTask<Void, Void, User> {

    @Override
    protected User doInBackground(Void... params) {
        UserInfoRepository repo = new UserInfoRepository();
        User user = repo.readUser();
        return user;
    }

}
