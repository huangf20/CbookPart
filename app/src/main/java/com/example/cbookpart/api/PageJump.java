package com.example.cbookpart.api;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class PageJump{
    public void jumpTo(String uri, Context context)
    {
        uri=uri.replace("packageName","com.zhaoxitech.cbook");
        Uri linkUrl=Uri.parse(uri);
        try {
            Intent intent=new Intent(Intent.ACTION_VIEW,linkUrl);
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context, "你没有安装此应用", Toast.LENGTH_SHORT).show();
        }
    }

    public void jumpToById(int id,String path,Context context) {
        Uri uri=new Uri.Builder()
                .scheme("zhaoxitech")
                .authority("com.zhaoxitech.cbook")
                .path(path)
                .appendQueryParameter("bookId",id+"")
                .build();
        try {
            Intent intent=new Intent(Intent.ACTION_VIEW,uri);
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context, "你没有安装此应用", Toast.LENGTH_SHORT).show();
        }
    }

}
