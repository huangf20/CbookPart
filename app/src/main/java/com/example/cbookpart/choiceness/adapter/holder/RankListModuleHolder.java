package com.example.cbookpart.choiceness.adapter.holder;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.adapter.ModuleRecyclerViewAdapter;
import com.example.cbookpart.choiceness.adapter.RankListRecycleViewAdapter;
import com.example.cbookpart.choiceness.data.ModuleBean.RankListModuleBean;
import com.example.cbookpart.tool.PageJump;

public class RankListModuleHolder extends AbsModuleHolder<RankListModuleBean>{
    TextView mTvTitle,mBtMore;
    RecyclerView mRecyclerView;
    Context mContext;
    public RankListModuleHolder(@NonNull View itemView, ModuleRecyclerViewAdapter moduleRecyclerViewAdapter) {
        super(itemView, moduleRecyclerViewAdapter);
        mTvTitle=itemView.findViewById(R.id.ranklist_title);
        mBtMore=itemView.findViewById(R.id.ranklist_bt_more);
        mRecyclerView=itemView.findViewById(R.id.ranklist_recyclerview);
        mContext=moduleRecyclerViewAdapter.getContext();
    }

    @Override
    public void bindData(RankListModuleBean moduleBean, int position) {
        RankListRecycleViewAdapter rankListRecycleViewAdapter=new RankListRecycleViewAdapter(moduleBean.getItems(),mContext);
        LinearLayoutManager managerHorizontal = new LinearLayoutManager(mContext);
        managerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(managerHorizontal);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(rankListRecycleViewAdapter);
        mBtMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PageJump.jumpTo(moduleBean.getLinkUrl(),mContext);
            }
        });
    }
}
