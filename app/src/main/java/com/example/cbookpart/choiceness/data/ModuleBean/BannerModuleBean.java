package com.example.cbookpart.choiceness.data.ModuleBean;

import com.example.cbookpart.choiceness.data.itemBean.BannerItemBean;

import java.util.ArrayList;

public class BannerModuleBean extends ModuleBean{
    public BannerModuleBean() {
    }

    public BannerModuleBean(int id, String type, String title, String channel, boolean showMore, String showType, int showNum, int startTime, int endTime, String linkUrl, boolean canDownload, boolean countDownNotShow, String btn, String targetType, ArrayList items, String canReceiveTimes) {
        super(id, type, title, channel, showMore, showType, showNum, startTime, endTime, linkUrl, canDownload, countDownNotShow, btn, targetType, items, canReceiveTimes);
    }

    @Override
    public ArrayList<BannerItemBean> getItems() {
        return super.getItems();
    }


}
