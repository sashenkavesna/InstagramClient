package com.epam.androidlab.instagramclient;


import com.epam.androidlab.instagramclient.presenters.UserInfoManager;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FollowsAndMediaTest {
    @Test
    public void userInfoManager_prepareFollowsOrMedia() {
        assertThat(UserInfoManager.prepareFollowsOrMedia("10000"), is("10k"));
    }
}
