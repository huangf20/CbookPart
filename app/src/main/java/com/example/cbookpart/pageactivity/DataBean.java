package com.example.cbookpart.pageactivity;

import com.example.cbookpart.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DataBean {
    public Integer imageRes;
    public String imageUrl;
    public String title;
    public int viewType;

    public DataBean(Integer imageRes, String title, int viewType) {
        this.imageRes = imageRes;
        this.title = title;
        this.viewType = viewType;
    }

    public DataBean(String imageUrl, String title, int viewType) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.viewType = viewType;
    }



    public static List<DataBean> getTestData() {
        List<DataBean> list = new ArrayList<>();
        list.add(new DataBean("https://zxbook-res.zhaoxitech.com/image/common/72547b37ea427140f4c39528b7fff2bf-229500.png!q_80", "7.13专题-追更", 1));
        list.add(new DataBean("https://zxbook-res.zhaoxitech.com/image/common/cb4d263edbf478a88002f2d834d19c8c-779866.png!q_80", "这个大佬很低调", 1));
        list.add(new DataBean("https://zxbook-res.zhaoxitech.com/image/common/4cfb1a9e303b9bdf5e36884d2d96d26c-81635.jpg!q_80", "万道龙皇", 1));
        list.add(new DataBean("https://zxbook-res.zhaoxitech.com/image/common/2b5a9a98f94759b11aee4384d604f4a2-594179.png!q_80", "盛世暖婚：贺少，适渴而止", 1));
        return list;
    }

    public static List<String> getColors(int size) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            list.add(getRandColor());
        }
        return list;
    }

    /**
     * 获取十六进制的颜色代码.例如  "#5A6677"
     * 分别取R、G、B的随机值，然后加起来即可
     *
     * @return String
     */
    public static String getRandColor() {
        String R, G, B;
        Random random = new Random();
        R = Integer.toHexString(random.nextInt(256)).toUpperCase();
        G = Integer.toHexString(random.nextInt(256)).toUpperCase();
        B = Integer.toHexString(random.nextInt(256)).toUpperCase();

        R = R.length() == 1 ? "0" + R : R;
        G = G.length() == 1 ? "0" + G : G;
        B = B.length() == 1 ? "0" + B : B;

        return "#" + R + G + B;
    }
}
