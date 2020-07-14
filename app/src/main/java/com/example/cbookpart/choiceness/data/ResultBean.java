package com.example.cbookpart.choiceness.data;

import java.util.ArrayList;

public class ResultBean {
    int code;
    String message;
    ArrayList<ValueBean>value;
    String logLevel;
    String desc;

    public ResultBean() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<ValueBean> getValue() {
        return value;
    }

    public void setValue(ArrayList<ValueBean> value) {
        this.value = value;
    }

    public String getLogLevel() {
        return logLevel;
    }

    public void setLogLevel(String logLevel) {
        this.logLevel = logLevel;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public ResultBean(int code, String message, ArrayList<ValueBean> value, String logLevel, String desc) {
        this.code = code;
        this.message = message;
        this.value = value;
        this.logLevel = logLevel;
        this.desc = desc;
    }
}
