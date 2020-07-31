package com.example.cbookpart.choiceness.data.itemBean;

import com.example.cbookpart.choiceness.data.baseBean.BaseItemBean;

import java.util.ArrayList;

public class RankListItemBean extends BaseItemBean {
    String title;
    String customDesc;
    ArrayList<RankListBook>books;

    public RankListItemBean() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomDesc() {
        return customDesc;
    }

    public void setCustomDesc(String customDesc) {
        this.customDesc = customDesc;
    }

    public ArrayList<RankListBook> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<RankListBook> books) {
        this.books = books;
    }

    public RankListItemBean(String title, String customDesc, ArrayList<RankListBook> books) {
        this.title = title;
        this.customDesc = customDesc;
        this.books = books;
    }
}
