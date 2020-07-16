package com.example.cbookpart.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.cbookpart.R;

public class BookListView extends FrameLayout {
    Context mContext;
    public BookListView(@NonNull Context context) {
        super(context);
        init(context);
    }



    public BookListView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BookListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public BookListView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }

    private void init(Context context) {
        mContext=context;
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_booklist_view,this,false);
        addView(view);
    }
}
