package com.example.cbookpart.choiceness.data.ModuleBean;

import com.example.cbookpart.choiceness.data.itemBean.BookItemBean;

import java.util.ArrayList;

public class BookModuleBean extends ModuleBean{
    public BookModuleBean() {
    }

    public BookModuleBean(int id, String type, String title, String channel, boolean showMore, String showType, int showNum, int startTime, int endTime, String linkUrl, boolean canDownload, boolean countDownNotShow, String btn, String targetType, ArrayList items, String canReceiveTimes) {
        super(id, type, title, channel, showMore, showType, showNum, startTime, endTime, linkUrl, canDownload, countDownNotShow, btn, targetType, items, canReceiveTimes);
    }

    @Override
    public ArrayList<BookItemBean> getItems() {
        return super.getItems();
    }
}
