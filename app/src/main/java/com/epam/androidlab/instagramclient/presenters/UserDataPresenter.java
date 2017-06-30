package com.epam.androidlab.instagramclient.presenters;


import com.epam.androidlab.instagramclient.asynctasks.UserInfoReaderTask;
import com.epam.androidlab.instagramclient.entity.User;
import com.epam.androidlab.instagramclient.fragments.UserInfoFragment;

import java.util.concurrent.ExecutionException;

public class UserDataPresenter implements UserInfoPresenter {
    private UserInfoFragment userInfoFragment;

    public UserDataPresenter(UserInfoFragment userInfoFragment) {
        this.userInfoFragment = userInfoFragment;
    }

    @Override
    public void onCreate() {
        UserInfoReaderTask task = new UserInfoReaderTask();
        task.execute();
        User user = new User();
        try {
            user = task.get();
            //todo: prepare strings
            userInfoFragment.update(
                    user.getUserName(),
                    user.getProfilePicture(),
                    user.getCounts().getMedia(),
                    user.getCounts().getFollows(),
                    user.getCounts().getFollowedBy()
            );
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
