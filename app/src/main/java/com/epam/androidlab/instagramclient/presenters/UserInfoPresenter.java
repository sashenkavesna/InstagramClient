package com.epam.androidlab.instagramclient.presenters;


import com.epam.androidlab.instagramclient.asynctasks.UserInfoReaderTask;
import com.epam.androidlab.instagramclient.entity.User;
import com.epam.androidlab.instagramclient.fragments.UserInfoFragment;
import com.epam.androidlab.instagramclient.handlers.UserResponseHandler;
import com.epam.androidlab.instagramclient.repository.TokenDataRepository;

import java.util.concurrent.ExecutionException;

public class UserInfoPresenter implements ProfilePresenter {
    private UserInfoFragment userInfoFragment;

    public UserInfoPresenter() {

    }

    public UserInfoPresenter(UserInfoFragment userInfoFragment) {
        this.userInfoFragment = userInfoFragment;
    }


    @Override
    public void onUpdateActivity() {
        new UserResponseHandler().fetchResponse(new TokenDataRepository().readAccessToken());
    }

    @Override
    public void onCreateProfileActivity() {
        UserInfoReaderTask task = new UserInfoReaderTask();
        task.execute();
        User user = new User();
        try {
            user = task.get();
            //todo: prepare strings
/*           userInfoFragment.update(
                    user.getUserName(),
                    user.getProfilePicture(),
                    user.getCounts().getMedia(),
                    user.getCounts().getFollows(),
                    user.getCounts().getFollowedBy()
            );*/
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }

    public static String prepareFollowsOrMedia(String count) {
        int MAX_LENGHT = 4;
        int MILLION_LENGHT = 6;
        String newCount = "";
        if (count.length() > MAX_LENGHT) {
            float dCount = Float.parseFloat(count);
            //   dCount /= 1000;
            if (count.length() < MILLION_LENGHT) {
                dCount /= 1000;
                newCount = String.valueOf(dCount);
                newCount = newCount.substring(0, 2);
                newCount = newCount.concat("k");
            } else {
                dCount /= 10000;
                newCount = String.valueOf(dCount);
                newCount = newCount.substring(0, 2);
                newCount = newCount.concat("m");
            }
        }
        return newCount;
    }
}
