package com.example.cbookpart.choiceness.data.itemBean;

import com.example.cbookpart.choiceness.data.baseBean.BaseItemBean;

import java.util.ArrayList;

public class BookItemBean extends BaseItemBean {
    int bookId;
    String author;
    String name;
    String shortDesc;
    String customDesc;
    String mark;
    String coverUrl;
    String endStatus;
    int wordCount;
    ArrayList<String>tags;
    String cornerInfo;
    String parentCategory;
    String category;
    String bookMark;
    String readingCount;
    String ranking;
    String cpid;

    public BookItemBean() {
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortDesc() {
        return shortDesc;
    }

    public void setShortDesc(String shortDesc) {
        this.shortDesc = shortDesc;
    }

    public String getCustomDesc() {
        return customDesc;
    }

    public void setCustomDesc(String customDesc) {
        this.customDesc = customDesc;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getEndStatus() {
        return endStatus;
    }

    public void setEndStatus(String endStatus) {
        this.endStatus = endStatus;
    }

    public int getWordCount() {
        return wordCount;
    }

    public void setWordCount(int wordCount) {
        this.wordCount = wordCount;
    }

    public ArrayList<String> getTags() {
        return tags;
    }

    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }

    public String getCornerInfo() {
        return cornerInfo;
    }

    public void setCornerInfo(String cornerInfo) {
        this.cornerInfo = cornerInfo;
    }

    public String getParentCategory() {
        return parentCategory;
    }

    public void setParentCategory(String parentCategory) {
        this.parentCategory = parentCategory;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBookMark() {
        return bookMark;
    }

    public void setBookMark(String bookMark) {
        this.bookMark = bookMark;
    }

    public String getReadingCount() {
        return readingCount;
    }

    public void setReadingCount(String readingCount) {
        this.readingCount = readingCount;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public String getCpid() {
        return cpid;
    }

    public void setCpid(String cpid) {
        this.cpid = cpid;
    }
}
