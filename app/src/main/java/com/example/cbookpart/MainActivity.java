package com.example.cbookpart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView mIvBookShelf;
    ImageView mIvChoiceness;
    ImageView mIvFree;
    ImageView mIvBookStore;
    ImageView mIvWelfare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mIvBookShelf=findViewById(R.id.bt_bookshelf);
        mIvBookStore=findViewById(R.id.bt_bookstore);
        mIvChoiceness=findViewById(R.id.bt_choiceness);
        mIvFree=findViewById(R.id.bt_free);
        mIvWelfare=findViewById(R.id.bt_welfare);
    }
}