package com.example.cbookpart.choiceness.data.ModuleBean;

import com.example.cbookpart.choiceness.data.itemBean.BookItemBean;

import java.util.ArrayList;

public class BookModuleBean extends ModuleBean<BookItemBean>{
    public BookModuleBean(ModuleBean moduleBean) {
        this.id=moduleBean.getId();
        this.type=moduleBean.getType();
        this.title=moduleBean.getTitle();
        this.channel=moduleBean.getChannel();
        this.showMore=moduleBean.isShowMore();
        this.showType=moduleBean.getShowType();
        this.showNum=moduleBean.getShowNum();
        this.startTime=moduleBean.getStartTime();
        this.endTime=moduleBean.getEndTime();
        this.linkUrl=moduleBean.getLinkUrl();
        this.canDownload=moduleBean.isCanDownload();
        this.countDownNotShow=moduleBean.isCountDownNotShow();
        this.btn=moduleBean.getBtn();
        this.targetType=moduleBean.getTargetType();
        this.items=moduleBean.getItems();
        this.canReceiveTimes=moduleBean.getCanReceiveTimes();
    }

    public BookModuleBean(int id, String type, String title, String channel, boolean showMore, String showType, int showNum, int startTime, int endTime, String linkUrl, boolean canDownload, boolean countDownNotShow, String btn, String targetType, ArrayList items, String canReceiveTimes) {
        super(id, type, title, channel, showMore, showType, showNum, startTime, endTime, linkUrl, canDownload, countDownNotShow, btn, targetType, items, canReceiveTimes);
    }

    @Override
    public ArrayList<BookItemBean> getItems() {
        return super.getItems();
    }
}
