package com.epam.androidlab.instagramclient;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;


public class CustomGalleryImage extends ImageView {
    //// TODO: 14.09.2017 fix spacing
    public CustomGalleryImage(Context context) {
        super(context);
    }

    public CustomGalleryImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomGalleryImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
