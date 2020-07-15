package com.example.cbookpart.choiceness.data.ModuleBean;

import com.example.cbookpart.choiceness.data.baseBean.BaseItemBean;
import com.example.cbookpart.choiceness.data.itemBean.BannerItemBean;

import java.util.ArrayList;

public class ModuleBean<T extends BaseItemBean>{
    int id;
    String type;
    String title;
    String channel;
    boolean showMore;
    String showType;
    int showNum;
    int startTime;
    int endTime;
    String linkUrl;
    boolean canDownload;
    boolean countDownNotShow;
    String btn;
    String targetType;
    ArrayList<T> items;
    String canReceiveTimes;

    public ModuleBean() {
    }

    public ModuleBean(int id, String type, String title, String channel, boolean showMore, String showType, int showNum, int startTime, int endTime, String linkUrl, boolean canDownload, boolean countDownNotShow, String btn, String targetType, ArrayList<T> items, String canReceiveTimes) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.channel = channel;
        this.showMore = showMore;
        this.showType = showType;
        this.showNum = showNum;
        this.startTime = startTime;
        this.endTime = endTime;
        this.linkUrl = linkUrl;
        this.canDownload = canDownload;
        this.countDownNotShow = countDownNotShow;
        this.btn = btn;
        this.targetType = targetType;
        this.items = items;
        this.canReceiveTimes = canReceiveTimes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public boolean isShowMore() {
        return showMore;
    }

    public void setShowMore(boolean showMore) {
        this.showMore = showMore;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public int getShowNum() {
        return showNum;
    }

    public void setShowNum(int showNum) {
        this.showNum = showNum;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public boolean isCanDownload() {
        return canDownload;
    }

    public void setCanDownload(boolean canDownload) {
        this.canDownload = canDownload;
    }

    public boolean isCountDownNotShow() {
        return countDownNotShow;
    }

    public void setCountDownNotShow(boolean countDownNotShow) {
        this.countDownNotShow = countDownNotShow;
    }

    public String getBtn() {
        return btn;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }

    public String getTargetType() {
        return targetType;
    }

    public void setTargetType(String targetType) {
        this.targetType = targetType;
    }

    public ArrayList<T> getItems() {
        return items;
    }

    public void setItems(ArrayList<T> items) {
        this.items = items;
    }

    public String getCanReceiveTimes() {
        return canReceiveTimes;
    }

    public void setCanReceiveTimes(String canReceiveTimes) {
        this.canReceiveTimes = canReceiveTimes;
    }
}
