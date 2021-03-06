package com.example.cbookpart.tool;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;



public class PageJump {
    public static void jumpTo(String uri, Context context) {
        uri = uri.replace("packageName", "com.zhaoxitech.cbook");
        Uri linkUrl = Uri.parse(uri);
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, linkUrl);
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context, "你没有安装此应用", Toast.LENGTH_SHORT).show();
        }
    }

    public static void jumpToDetailById(int id, Context context) {
        Uri uri = new Uri.Builder()
                .scheme("zhaoxitech")
                .authority("com.zhaoxitech.cbook")
                .path("bookdetail")
                .appendQueryParameter("bookId", id + "")
                .build();
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context, "你没有安装此应用", Toast.LENGTH_SHORT).show();
        }
    }

    public static void jumpToReaderById(int id, Context context) {
        Uri uri = new Uri.Builder()
                .scheme("zhaoxitech")
                .authority("com.zhaoxitech.cbook")
                .path("reader")
                .appendQueryParameter("bookId", id + "")
                .build();
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            context.startActivity(intent);
        } catch (android.content.ActivityNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(context, "你没有安装此应用", Toast.LENGTH_SHORT).show();
        }
    }
}
