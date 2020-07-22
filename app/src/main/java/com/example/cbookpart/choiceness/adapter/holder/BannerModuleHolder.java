package com.example.cbookpart.choiceness.adapter.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.adapter.BannerImageAdapter;
import com.example.cbookpart.choiceness.adapter.ModuleRecyclerViewAdapter;
import com.example.cbookpart.choiceness.data.ModuleBean.BannerModuleBean;
import com.youth.banner.Banner;
import com.youth.banner.config.IndicatorConfig;
import com.youth.banner.indicator.CircleIndicator;

public class BannerModuleHolder extends AbsModuleHolder<BannerModuleBean> {

    private Banner mBanner;
    private Context mContext;
    private TextView mTvTitle, mTvText;
    private View mView;

    public BannerModuleHolder(@NonNull View itemView, ModuleRecyclerViewAdapter moduleRecyclerViewAdapter) {
        super(itemView, moduleRecyclerViewAdapter);
        mView = itemView;
        mBanner = itemView.findViewById(R.id.banner_module);
        mContext = moduleRecyclerViewAdapter.getContext();
        mTvTitle = itemView.findViewById(R.id.banner_tv_title);
        mTvText = itemView.findViewById(R.id.banner_tv_text);
    }

    @Override
    public void bindData(BannerModuleBean moduleBean, int position) {
        if (moduleBean.getItems() != null && moduleBean.getItems().size() > 0) {
            mBanner.addBannerLifecycleObserver(null)
                    .setAdapter(new BannerImageAdapter(moduleBean.getItems()))
                    .setIndicator(new CircleIndicator(mContext))
                    .setIndicatorGravity(IndicatorConfig.Direction.RIGHT)
                    .setBannerRound(30)
                    .setIndicatorNormalColorRes(R.color.colorAccent)
                    .setIndicatorSelectedColorRes(R.color.colorPrimaryDark)
                    .start();
            if (moduleBean.getShowType().equals("banner_row")) {
                ViewGroup.LayoutParams layoutParams = mView.getLayoutParams();
                layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                layoutParams.height = ViewGroup.LayoutParams.WRAP_CONTENT;
                mTvTitle.setText(moduleBean.getItems().get(0).getTitle());
                mTvText.setText(moduleBean.getItems().get(0).getText());
            } else {
                mTvTitle.setText("");
                mTvText.setText("");
            }
        }


    }


}
