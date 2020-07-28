package com.example.cbookpart.tool;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageLoader {
    public static void setImageToView(Context context, String uri, ImageView imageView){
        Glide.with(context)
                .load(uri)
                .into(imageView);
    }
}
