package com.epam.androidlab.instagramclient.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.epam.androidlab.instagramclient.R;
import com.epam.androidlab.instagramclient.adapters.MediaAdapter;
import com.epam.androidlab.instagramclient.presenters.MediaPresenter;

import java.util.ArrayList;

public class MediaFragment extends Fragment implements MediaView {
    private GridView gridView;
    private MediaPresenter presenter;
    private MediaAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //   presenter = new MediaPresenter(this);
        // presenter.onFragmentCreate();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//// TODO: 30.06.2017 onviewcreate

        View view = inflater.inflate(R.layout.media_fragment_layout, container, false);
        gridView = (GridView) view.findViewById(R.id.gridview);
        //gridView.setAdapter(adapter);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //   presenter.onActivityCreate();
    }

    @Override
    public void update(ArrayList<String> imgUrls) {
        gridView.setAdapter(new MediaAdapter(this.getContext(), imgUrls));
    }
}
