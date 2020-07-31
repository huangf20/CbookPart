package com.example.cbookpart.choiceness.data.ModuleBean;

import com.example.cbookpart.choiceness.data.itemBean.RankListItemBean;

import java.util.ArrayList;

public class RankListModuleBean extends ModuleBean<RankListItemBean>{

    public RankListModuleBean(ModuleBean moduleBean) {
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
    public ArrayList<RankListItemBean> getItems() {
        return super.getItems();
    }
}
