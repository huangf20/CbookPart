package com.example.cbookpart.choiceness.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.cbookpart.R;
import com.example.cbookpart.api.ApiService;
import com.example.cbookpart.api.RetrofitManager;
import com.example.cbookpart.choiceness.data.ResultBean;
import com.example.cbookpart.choiceness.data.ValueBean;
import com.example.cbookpart.choiceness.fragment.TabFragmentPagerAdapter;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONObject;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ValuePageFragment extends Fragment {
    private View mView;
    private ViewPager mViewPager;
    private TabFragmentPagerAdapter mTabFragmentPagerAdapter;
    private Context mContext;
    private ArrayList<ValueBean> mValueBeans=new ArrayList<>();

    public ValuePageFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.value_fragment, container, false);
        return mView;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext=getContext();
        getData();
    }

    private void getData() {
        ApiService apiService= RetrofitManager.retrofit().create(ApiService.class);
        apiService.getList(1,0)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResultBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Toast.makeText(mContext,"开始连接",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNext(ResultBean resultBean) {
                        mValueBeans = resultBean.getValue();
                        onViewCreated(mView,null,0);

                    }

                    @Override
                    public void onError(Throwable e) {
                        Toast.makeText(mContext,"请求失败",Toast.LENGTH_SHORT).show();
                        Log.d("TAG", e.getMessage());

                    }

                    @Override
                    public void onComplete() {
                        Toast.makeText(mContext,"请求成功",Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState,int i) {
        mTabFragmentPagerAdapter = new TabFragmentPagerAdapter(getChildFragmentManager(),mValueBeans);
        mViewPager = view.findViewById(R.id.view_pager);
        mViewPager.setAdapter(mTabFragmentPagerAdapter);
        TabLayout tabLayout = view.findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
