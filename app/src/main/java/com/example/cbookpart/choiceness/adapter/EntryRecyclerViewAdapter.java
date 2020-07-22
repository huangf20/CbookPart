package com.example.cbookpart.choiceness.adapter;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cbookpart.R;
import com.example.cbookpart.api.PageJump;
import com.example.cbookpart.choiceness.data.itemBean.EntryItemBean;

import java.util.ArrayList;

public class EntryRecyclerViewAdapter extends RecyclerView.Adapter<EntryRecyclerViewAdapter.EntryViewHolder> {
    private ArrayList<EntryItemBean> mEntryItemBeans = new ArrayList<>();
    private Context mContext;

    public void setEntryItemBeans(ArrayList<EntryItemBean> entryItemBeans) {
        mEntryItemBeans = entryItemBeans;
        notifyDataSetChanged();
    }

    public EntryRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    @NonNull
    @Override
    public EntryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_entry_item, parent, false);
        //item平分屏幕
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        int widthPixels = metrics.widthPixels;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = widthPixels / mEntryItemBeans.size();
        EntryViewHolder entryViewHolder = new EntryViewHolder(view);
        return entryViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull EntryViewHolder holder, int position) {
        holder.bindData(mEntryItemBeans.get(position), position);
    }


    @Override
    public int getItemCount() {
        return mEntryItemBeans.size();
    }

    public class EntryViewHolder extends RecyclerView.ViewHolder {

        ImageView mImageView;
        TextView mTextView;

        public EntryViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.entry_imageview);
            mTextView = itemView.findViewById(R.id.entry_textview);

        }

        public void bindData(EntryItemBean entryItemBean, int position) {
            Glide.with(mContext)
                    .load(entryItemBean.getImgUrl())
                    .into(mImageView);
            mTextView.setText(entryItemBean.getTitle());

            mImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PageJump.jumpTo(entryItemBean.getLinkUrl(), mContext);
                }
            });
            mTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PageJump.jumpTo(entryItemBean.getLinkUrl(), mContext);
                }
            });
        }


    }
}
