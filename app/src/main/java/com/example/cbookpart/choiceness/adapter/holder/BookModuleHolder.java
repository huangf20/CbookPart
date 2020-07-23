package com.example.cbookpart.choiceness.adapter.holder;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;

import com.example.cbookpart.R;
import com.example.cbookpart.choiceness.adapter.ModuleRecyclerViewAdapter;
import com.example.cbookpart.choiceness.data.ModuleBean.BookModuleBean;
import com.example.cbookpart.choiceness.view.BookListView;

public class BookModuleHolder extends AbsModuleHolder<BookModuleBean> {

    Context mContext;
    BookListView mBookListView;

    public BookModuleHolder(@NonNull View itemView, ModuleRecyclerViewAdapter moduleRecyclerViewAdapter) {
        super(itemView, moduleRecyclerViewAdapter);
        mContext = moduleRecyclerViewAdapter.getContext();
        mBookListView = itemView.findViewById(R.id.book_list_view);
    }

    @Override
    public void bindData(BookModuleBean moduleBean, int position) {
        mBookListView.setModuleBean(moduleBean);
    }
}
