package com.example.cbookpart.pageactivity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.fragment.ValuePageFragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ImageView mIvBookShelf, mIvChoiceness, mIvFree, mIvBookStore, mIvWelfare;
    private TextView mTvBookShelf, mTvChoiceness, mTvFree, mTvBookStore, mTvWelfare;
    private ArrayList<ImageView> mImageViews = new ArrayList<>();
    private ArrayList<TextView> mTextViews = new ArrayList<>();
    private ArrayList<Integer> mImagesNow = new ArrayList<>();
    private ArrayList<Integer> mImagesNext = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private Fragment mPageFragmentNow;
    private Map<Integer, ValuePageFragment> mFragmentMap = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        mIvBookShelf = findViewById(R.id.bt_bookshelf);
        mImageViews.add(mIvBookShelf);
        mIvChoiceness = findViewById(R.id.bt_choiceness);
        mImageViews.add(mIvChoiceness);
        mIvFree = findViewById(R.id.bt_free);
        mImageViews.add(mIvFree);
        mIvBookStore = findViewById(R.id.bt_bookstore);
        mImageViews.add(mIvBookStore);
        mIvWelfare = findViewById(R.id.bt_welfare);
        mImageViews.add(mIvWelfare);

        mTvBookShelf = findViewById(R.id.tv_bookshelf);
        mTextViews.add(mTvBookShelf);
        mTvChoiceness = findViewById(R.id.tv_choiceness);
        mTextViews.add(mTvChoiceness);
        mTvFree = findViewById(R.id.tv_free);
        mTextViews.add(mTvFree);
        mTvBookStore = findViewById(R.id.tv_bookstore);
        mTextViews.add(mTvBookStore);
        mTvWelfare = findViewById(R.id.tv_welfare);
        mTextViews.add(mTvWelfare);

        mImagesNow.add(R.drawable.bookshelf);
        mImagesNow.add(R.drawable.choiceness);
        mImagesNow.add(R.drawable.free);
        mImagesNow.add(R.drawable.bookstores);
        mImagesNow.add(R.drawable.welfare);

        mImagesNext.add(R.drawable.bookshelf_replace);
        mImagesNext.add(R.drawable.choiceness_replace);
        mImagesNext.add(R.drawable.free_replace);
        mImagesNext.add(R.drawable.bookstore_replace);
        mImagesNext.add(R.drawable.welfare_replace);

        mIvBookShelf.setOnClickListener(this);
        mIvBookStore.setOnClickListener(this);
        mIvChoiceness.setOnClickListener(this);
        mIvFree.setOnClickListener(this);
        mIvWelfare.setOnClickListener(this);
        mTvBookShelf.setOnClickListener(this);
        mTvBookStore.setOnClickListener(this);
        mTvChoiceness.setOnClickListener(this);
        mTvFree.setOnClickListener(this);
        mTvWelfare.setOnClickListener(this);
        mFragmentManager = getSupportFragmentManager();
        mPageFragmentNow = new ValuePageFragment();


    }

    private void replaceFragment(Fragment fragment, boolean isAdd) {
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        if (!isAdd) {
            transaction
                    .hide(mPageFragmentNow)
                    .add(R.id.view_fragment, fragment);
        } else {
            transaction
                    .hide(mPageFragmentNow)
                    .show(fragment);

        }
        mPageFragmentNow = fragment;
        transaction.commit();
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onClick(View view) {

        for (ImageView imageView : mImageViews) {
            int index = mImageViews.indexOf(imageView);

            if (view.getId() == imageView.getId() || view.getId() == mTextViews.get(index).getId()) {
                imageView.setImageResource(mImagesNext.get(index));
                mTextViews.get(index).setTextColor(Color.rgb(248, 111, 39));
                if (index == 1) {
                    replaceFragment(new ValuePageFragment(), false);
                }
            } else {
                imageView.setImageResource(mImagesNow.get(index));
                mTextViews.get(index).setTextColor(Color.rgb(115, 115, 115));
            }
        }


    }
}