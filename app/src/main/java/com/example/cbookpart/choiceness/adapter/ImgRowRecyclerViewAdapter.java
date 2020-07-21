package com.example.cbookpart.choiceness.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.data.itemBean.BookItemBean;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ImgRowRecyclerViewAdapter extends RecyclerView.Adapter<ImgRowRecyclerViewAdapter.ImgRowViewHolder> {
    ArrayList<BookItemBean> mBookItemBeans=new ArrayList<>();
    private Context mContext;

    public ImgRowRecyclerViewAdapter(ArrayList<BookItemBean> bookItemBeans, Context context) {
        mBookItemBeans = bookItemBeans;
        mContext = context;
    }

    @NonNull
    @Override
    public ImgRowViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.img_row_item,parent,false);

        return new ImgRowViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImgRowViewHolder holder, int position) {
        BookItemBean bookItemBean=mBookItemBeans.get(position);
        holder.mTvName.setText(bookItemBean.getName());
        holder.mTvName.setLines(2);
        holder.mTvReadCount.setText(bookItemBean.getReadingCount());
        Glide.with(mContext)
                .load(bookItemBean.getCoverUrl())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {

        return mBookItemBeans.size();
    }

    public class ImgRowViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTvName,mTvReadCount;
        public ImgRowViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.img_row_icon);
            mTvName=itemView.findViewById(R.id.img_row_name);
            mTvReadCount=itemView.findViewById(R.id.img_row_readcount);
        }
    }
}
