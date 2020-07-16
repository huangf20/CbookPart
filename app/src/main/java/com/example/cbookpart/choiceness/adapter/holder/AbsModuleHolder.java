package com.example.cbookpart.choiceness.adapter.holder;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cbookpart.choiceness.adapter.ModuleRecyclerViewAdapter;
import com.example.cbookpart.choiceness.data.ModuleBean.ModuleBean;

public abstract class AbsModuleHolder<T extends ModuleBean> extends RecyclerView.ViewHolder{

    public AbsModuleHolder(@NonNull View itemView, ModuleRecyclerViewAdapter moduleRecyclerViewAdapter) {
        super(itemView);
    }
    public abstract void bindData(T moduleBean,int position);
}
