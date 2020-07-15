package com.example.cbookpart.pageactivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.data.baseBean.BaseItemBean;
import com.example.cbookpart.choiceness.data.itemBean.BannerItemBean;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

import org.json.JSONObject;

import java.util.ArrayList;


public class TestActivity extends AppCompatActivity {
    private Banner banner;
    private ArrayList<String> list_path;
    private ArrayList<String> list_title;

    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);
        init();



    }

    @SuppressLint("ResourceType")
    private void init() {
        banner = (Banner) findViewById(R.id.banner_demo);
        //放图片地址的集合
        banner.addBannerLifecycleObserver(this)
                .setAdapter(new ImageAdapter(DataBean.getTestData()))
                .setIndicator(new CircleIndicator(this))
                .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                .setBannerRound(30)
                .setIndicatorNormalColorRes(R.color.colorAccent)
                .setIndicatorSelectedColorRes(R.color.colorPrimaryDark)
                .start();

    }


}
