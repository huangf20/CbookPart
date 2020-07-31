package com.example.cbookpart.choiceness.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.data.ModuleBean.RankListModuleBean;
import com.example.cbookpart.choiceness.data.itemBean.RankListItemBean;

import java.util.ArrayList;

public class RankListRecycleViewAdapter extends RecyclerView.Adapter<RankListRecycleViewAdapter.ViewHolder> {
    ArrayList<RankListItemBean> mRankListItemBeans =new ArrayList<>();
    Context mContext;

    public RankListRecycleViewAdapter(ArrayList<RankListItemBean> rankListItemBeans, Context context) {
        mRankListItemBeans = rankListItemBeans;
        mContext = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(mContext).inflate(R.layout.layout_ranklist_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        //占屏幕的4/5
        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        int widthPixels = metrics.widthPixels;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = widthPixels / 5*4;
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if(position==1){
            holder.mTvTitle.setBackgroundResource(R.drawable.pinkground);
        }
        RankListItemBean rankListItemBean=mRankListItemBeans.get(position);
        holder.mTvTitle.setText(rankListItemBean.getTitle());
        holder.mTvNameOne.setText(rankListItemBean.getBooks().get(0).getName());
        holder.mTvNameTwo.setText(rankListItemBean.getBooks().get(1).getName());
        holder.mTvNameThree.setText(rankListItemBean.getBooks().get(2).getName());
        holder.mTvNameFour.setText(rankListItemBean.getBooks().get(3).getName());
        holder.mTvNameFive.setText(rankListItemBean.getBooks().get(4).getName());

        holder.mTvAuthorOne.setText(rankListItemBean.getBooks().get(0).getAuthor());
        holder.mTvAuthorTwo.setText(rankListItemBean.getBooks().get(1).getAuthor());
        holder.mTvAuthorThree.setText(rankListItemBean.getBooks().get(2).getAuthor());
        holder.mTvAuthorFour.setText(rankListItemBean.getBooks().get(3).getAuthor());
        holder.mTvAuthorFive.setText(rankListItemBean.getBooks().get(4).getAuthor());
    }

    @Override
    public int getItemCount() {
        return mRankListItemBeans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTvTitle,mTvNameOne,mTvNameTwo,mTvNameThree,mTvNameFour,mTvNameFive
                ,mTvAuthorOne,mTvAuthorTwo,mTvAuthorThree,mTvAuthorFour,mTvAuthorFive;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvTitle=itemView.findViewById(R.id.ranklist_title);
            mTvNameOne=itemView.findViewById(R.id.ranklist_title_one);
            mTvNameTwo=itemView.findViewById(R.id.ranklist_title_two);
            mTvNameThree=itemView.findViewById(R.id.ranklist_title_three);
            mTvNameFour=itemView.findViewById(R.id.ranklist_title_four);
            mTvNameFive=itemView.findViewById(R.id.ranklist_title_five);

            mTvAuthorOne=itemView.findViewById(R.id.ranklist_item_author_one);
            mTvAuthorTwo=itemView.findViewById(R.id.ranklist_item_author_two);
            mTvAuthorThree=itemView.findViewById(R.id.ranklist_item_author_three);
            mTvAuthorFour=itemView.findViewById(R.id.ranklist_item_author_four);
            mTvAuthorFive=itemView.findViewById(R.id.ranklist_item_author_five);
        }
    }
}
