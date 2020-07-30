package com.example.cbookpart.choiceness.data.itemBean;

import com.example.cbookpart.choiceness.data.baseBean.BaseItemBean;

public class BannerItemBean extends BaseItemBean {
    String title;
    String text;
    String imgUrl;
    String linkUrl;

    public BannerItemBean() {
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }
}
