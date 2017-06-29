package com.epam.androidlab.instagramclient.fragments;


public interface UserInfoView {
    void update(String userName,
                String profilePic,
                String mediaCount,
                String followsCount,
                String followedByCount
    );
}
