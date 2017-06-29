package com.epam.androidlab.instagramclient.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.epam.androidlab.instagramclient.R;
import com.squareup.picasso.Picasso;

public class UserInfoFragment extends Fragment implements UserInfoView {
    private View view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.user_info_fragment_layout, container, false);
        return view;
    }

    @Override
    public void update(String userName, String profilePic, String mediaCount, String followsCount, String followedByCount) {
        //// TODO: 26.06.2017 add username , mediacount in fragment
        ImageView userPic = (ImageView) view.findViewById(R.id.user_pic);
        Picasso.with(this.getContext()).load(profilePic).into(userPic);
        TextView followsCountView = (TextView) view.findViewById(R.id.follows_number);
        followsCountView.setText(followsCount);
        TextView followedByCountView = (TextView) view.findViewById(R.id.followed_by_number);
        followedByCountView.setText(followedByCount);
    }
}
