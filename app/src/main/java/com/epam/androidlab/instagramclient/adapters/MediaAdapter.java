package com.epam.androidlab.instagramclient.adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.epam.androidlab.instagramclient.entity.Media;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MediaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Media> media;

    //// TODO: 30.06.2017 create media model for grid?
    public MediaAdapter(Context context, ArrayList<Media> media) {
        this.context = context;
        this.media = media;
    }

    @Override
    public int getCount() {
        return media.size();
    }

    @Override
    public Object getItem(int position) {
        return media.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imgView;
        if (convertView == null) {
            Media media = (Media) getItem(position);
            String imgUrl = media.getImages().getTh().getUrl();
            imgView = new ImageView(context);
            Picasso.with(context).load(imgUrl).into(imgView);
        } else {
            imgView = (ImageView) convertView;
        }
        return imgView;
    }
}
