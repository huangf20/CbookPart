package com.example.cbookpart;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cbookpart.api.ApiService;
import com.example.cbookpart.api.RetrofitManager;
import com.example.cbookpart.choiceness.data.ResultBean;
import com.example.cbookpart.choiceness.data.ValueBean;

import java.util.ArrayList;

import io.reactivex.Observer;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TestActivity extends AppCompatActivity {

    private static final String TAG = "Rxjava";
    TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_test);
        init();
    }

    private void init() {
        mTextView=findViewById(R.id.test_textview);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
            }
        });
    }

    private void getData() {
        ApiService apiService= RetrofitManager.retrofit().create(ApiService.class);
        apiService.getList(1,0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Toast.makeText(TestActivity.this,"开始连接",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ResultBean resultBean) {
                        ArrayList<ValueBean> valueBeans = resultBean.getValue();
                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(TestActivity.this,"请求失败",Toast.LENGTH_SHORT).show();
                        Log.d(TAG, e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(TestActivity.this,"请求成功",Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
