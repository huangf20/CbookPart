package com.example.cbookpart.choiceness.adapter.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.adapter.EntryRecyclerViewAdapter;
import com.example.cbookpart.choiceness.adapter.ModuleRecyclerViewAdapter;
import com.example.cbookpart.choiceness.data.ModuleBean.EntryModuleBean;

public class EntryModuleHolder extends AbsModuleHolder<EntryModuleBean>{
    private Context mContext;
    private RecyclerView mRecyclerView;
    public EntryModuleHolder(@NonNull View itemView, ModuleRecyclerViewAdapter moduleRecyclerViewAdapter) {
        super(itemView, moduleRecyclerViewAdapter);
        mContext=moduleRecyclerViewAdapter.getContext();
        mRecyclerView=itemView.findViewById(R.id.entry_recyclerview);
    }

    @Override
    public void bindData(EntryModuleBean moduleBean, int position) {
        EntryRecyclerViewAdapter entryRecyclerViewAdapter=new EntryRecyclerViewAdapter(mContext);
        LinearLayoutManager managerHorizontal = new LinearLayoutManager(mContext);
        managerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(managerHorizontal);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setAdapter(entryRecyclerViewAdapter);
        entryRecyclerViewAdapter.setEntryItemBeans(moduleBean.getItems());
    }
}
