package com.epam.androidlab.instagramclient;


import com.epam.androidlab.instagramclient.presenters.UserInfoPresenter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FollowsAndMediaTest {
    @Test
    public void userInfoManager_prepareFollowsOrMedia() {
        assertThat(UserInfoPresenter.prepareFollowsOrMedia("10000"), is("10k"));
    }
}
