package com.example.cbookpart.choiceness.adapter.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.adapter.BannerImageAdapter;
import com.example.cbookpart.choiceness.adapter.ModuleRecyclerViewAdapter;
import com.example.cbookpart.choiceness.data.ModuleBean.BannerModuleBean;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

public class BannerModuleHolder extends AbsModuleHolder<BannerModuleBean>{

    private Banner mBanner;
    private Context mContext;
    public BannerModuleHolder(@NonNull View itemView, ModuleRecyclerViewAdapter moduleRecyclerViewAdapter) {
        super(itemView,moduleRecyclerViewAdapter);
        mBanner=itemView.findViewById(R.id.banner_module);
        mContext=moduleRecyclerViewAdapter.getContext();
    }

    @Override
    public void bindData(BannerModuleBean moduleBean, int position) {
        if(moduleBean.getItems()!=null)
        {
            mBanner.addBannerLifecycleObserver(null)
                    .setAdapter(new BannerImageAdapter(moduleBean.getItems()))
                    .setIndicator(new CircleIndicator(mContext))
                    .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                    .setBannerRound(30)
                    .setIndicatorNormalColorRes(R.color.colorAccent)
                    .setIndicatorSelectedColorRes(R.color.colorPrimaryDark)
                    .start();
        }

    }


}
