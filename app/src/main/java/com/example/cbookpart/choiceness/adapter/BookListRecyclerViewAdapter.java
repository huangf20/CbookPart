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
import com.example.cbookpart.tool.PageJump;
import com.example.cbookpart.choiceness.data.itemBean.BookItemBean;


import java.util.ArrayList;

public class BookListRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    ArrayList<BookItemBean> mBookItemBeans = new ArrayList<>();
    private Context mContext;
    private int mRecyclerViewType;
    ArrayList<Integer> mViewType = new ArrayList<>();
    public final static int TYPE_IMG_ROW=0;
    public final static int TYPE_COLUMN=1;
    public final static int TYPE_ROW=2;

    public BookListRecyclerViewAdapter(ArrayList<BookItemBean> bookItemBeans, Context context, int type) {
        mRecyclerViewType = type;
        mBookItemBeans = bookItemBeans;
        mContext = context;
        mViewType.add(R.layout.img_row_item);
        mViewType.add(R.layout.column_item);
        mViewType.add(R.layout.row_item);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(viewType, parent, false);
        switch (mRecyclerViewType) {
            case TYPE_IMG_ROW:
                return new ImgRowViewHolder(view);
            case TYPE_COLUMN:
                return new ColumnViewHolder(view);
            case TYPE_ROW:
                return new RowViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        BookItemBean bookItemBean = mBookItemBeans.get(position);
        if (holder instanceof ImgRowViewHolder) {
            ImgRowViewHolder imgRowViewHolder = (ImgRowViewHolder) holder;
            imgRowViewHolder.bindData(bookItemBean);
        } else if (holder instanceof ColumnViewHolder) {
            ColumnViewHolder columnViewHolder = (ColumnViewHolder) holder;
            columnViewHolder.bindData(bookItemBean);
        } else if (holder instanceof RowViewHolder) {
            RowViewHolder rowViewHolder = (RowViewHolder) holder;
            rowViewHolder.bindData(bookItemBean);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mViewType.get(mRecyclerViewType);
    }

    @Override
    public int getItemCount() {
        if(mRecyclerViewType==TYPE_ROW){
            return 8;
        }
        return mBookItemBeans.size();
    }

    public class ImgRowViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTvName, mTvReadCount;
        View mView;

        public ImgRowViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mImageView = itemView.findViewById(R.id.img_row_icon);
            mTvName = itemView.findViewById(R.id.img_row_name);
            mTvReadCount = itemView.findViewById(R.id.img_row_readcount);
        }

        public void bindData(BookItemBean bookItemBean) {
            mTvName.setText(bookItemBean.getName());
            mTvName.setLines(2);
            mTvReadCount.setText(bookItemBean.getReadingCount());
            Glide.with(mContext)
                    .load(bookItemBean.getCoverUrl())
                    .into(mImageView);
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PageJump.jumpToDetailById(bookItemBean.getBookId(),  mContext);
                }
            });

        }
    }

    public class ColumnViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTvName, mTvShortDesc, mTvAuthor, mTvWordCount;
        View mView;

        public ColumnViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
            mImageView = itemView.findViewById(R.id.icon_column);
            mTvName = itemView.findViewById(R.id.tv_name_column);
            mTvShortDesc = itemView.findViewById(R.id.shortDesc_column);
            mTvAuthor = itemView.findViewById(R.id.author_column);
            mTvWordCount = itemView.findViewById(R.id.wordCount_column);
        }

        public void bindData(BookItemBean bookItemBean) {
            Glide.with(mContext)
                    .load(bookItemBean.getCoverUrl())
                    .into(mImageView);
            mTvName.setText(bookItemBean.getName());
            mTvShortDesc.setText(bookItemBean.getShortDesc());
            mTvAuthor.setText(bookItemBean.getAuthor());
            mTvWordCount.setText(bookItemBean.getWordCount() / 10000 + "万字");
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PageJump.jumpToDetailById(bookItemBean.getBookId(), mContext);
                }
            });
        }
    }

    public class RowViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;
        TextView mTvName;
        View mView;
        public RowViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView=itemView.findViewById(R.id.row_icon);
            mTvName=itemView.findViewById(R.id.row_name);
            mView=itemView;
        }

        public void bindData(BookItemBean bookItemBean) {
            Glide.with(mContext)
                    .load(bookItemBean.getCoverUrl())
                    .into(mImageView);
            mTvName.setText(bookItemBean.getName());
            mView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    PageJump.jumpToDetailById(bookItemBean.getBookId(),mContext);
                }
            });
        }
    }
}
