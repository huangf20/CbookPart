package com.example.cbookpart.choiceness.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cbookpart.api.PageJump;
import com.example.cbookpart.choiceness.data.itemBean.BannerItemBean;
import com.example.cbookpart.pageactivity.DataBean;
import com.example.cbookpart.pageactivity.ImageAdapter;
import com.youth.banner.adapter.BannerAdapter;

import java.util.List;

public class BannerImageAdapter extends BannerAdapter<BannerItemBean, BannerImageAdapter.BannerViewHolder> {

    Context mContext;
    public BannerImageAdapter(List<BannerItemBean> datas) {
        super(datas);
    }

    @Override
    public BannerViewHolder onCreateHolder(ViewGroup parent, int viewType) {
        mContext=parent.getContext();
        ImageView imageView = new ImageView(parent.getContext());
        //注意，必须设置为match_parent，这个是viewpager2强制要求的
        imageView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return new BannerImageAdapter.BannerViewHolder(imageView);
    }

    @Override
    public void onBindView(BannerViewHolder holder, BannerItemBean data, int position, int size) {
        ImageView imageView=holder.imageView;
        Glide.with(mContext)
                .load(data.getImgUrl())
                .into(imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PageJump pageJump=new PageJump();
                pageJump.jumpTo(data.getLinkUrl(),mContext);
            }
        });
    }

    class BannerViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public BannerViewHolder(@NonNull ImageView view) {
            super(view);
            this.imageView = view;
        }
    }
}
