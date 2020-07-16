package com.example.cbookpart.choiceness.adapter.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.cbookpart.choiceness.adapter.ModuleRecyclerViewAdapter;
import com.example.cbookpart.choiceness.data.ModuleBean.BookModuleBean;

public class BookModuleHolder extends AbsModuleHolder<BookModuleBean> {

    Context mContext;

    public BookModuleHolder(@NonNull View itemView, ModuleRecyclerViewAdapter moduleRecyclerViewAdapter) {
        super(itemView, moduleRecyclerViewAdapter);
        mContext=moduleRecyclerViewAdapter.getContext();

    }

    @Override
    public void bindData(BookModuleBean moduleBean, int position) {

    }
}
