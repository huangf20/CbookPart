package com.example.cbookpart.choiceness.data.ModuleBean;

import com.example.cbookpart.choiceness.data.itemBean.EntryItemBean;

import java.util.ArrayList;

public class EntryModuleBean extends ModuleBean<EntryItemBean>{
    public EntryModuleBean(ModuleBean moduleBean) {
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

    @Override
    public ArrayList<EntryItemBean> getItems() {
        return super.getItems();
    }
}
