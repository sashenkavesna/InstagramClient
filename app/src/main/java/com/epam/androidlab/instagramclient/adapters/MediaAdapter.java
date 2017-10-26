package com.epam.androidlab.instagramclient.adapters;


import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.epam.androidlab.instagramclient.CustomGalleryImage;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MediaAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<String> media;

    public MediaAdapter(Context context, ArrayList<String> media) {
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
     /*   FrameLayout layout=new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams=new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
        );*/
        CustomGalleryImage imgView;
        if (convertView == null) {
            String imgUrl = media.get(position);
            imgView = new CustomGalleryImage(context);
            Picasso.with(context).load(imgUrl).into(imgView);
            //   layout.addView(imgView,layoutParams);
        } else {
            // layout=(FrameLayout)convertView;
            imgView = (CustomGalleryImage) convertView;
        }

        return imgView;
    }
}
