package com.example.cbookpart.choiceness.data;

import java.util.ArrayList;

public class ValueBean {
    int id;
    String title;
    String type;
    String channel;
    String linkUrl;
    String channels;
    ArrayList<ModuleBean>mModules;

    public ValueBean(int id, String title, String type, String channel, String linkUrl, String channels, ArrayList<ModuleBean> modules) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.channel = channel;
        this.linkUrl = linkUrl;
        this.channels = channels;
        mModules = modules;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public String getChannels() {
        return channels;
    }

    public void setChannels(String channels) {
        this.channels = channels;
    }

    public ArrayList<ModuleBean> getModules() {
        return mModules;
    }

    public void setModules(ArrayList<ModuleBean> modules) {
        mModules = modules;
    }
}
