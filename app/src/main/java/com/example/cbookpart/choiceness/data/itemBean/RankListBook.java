package com.example.cbookpart.choiceness.data.itemBean;

public class RankListBook {
    int bookId;
    String name ;
    String author;
    String coverUrl;

    public RankListBook() {
    }

    public RankListBook(int bookId, String name, String author, String coverUrl) {
        this.bookId = bookId;
        this.name = name;
        this.author = author;
        this.coverUrl = coverUrl;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
