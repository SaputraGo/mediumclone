package com.android.mediumclone;

/**
 * Created by kamalshree on 5/14/2018.
 */

public class Article {
    private String title;
    private String maintitle;
    private String author;
    private String date;
    private String time;
    private int image;

    public Article(String maintitle, String title, String author, String date, String time, int image) {
        this.maintitle = maintitle;
        this.title = title;
        this.author = author;
        this.date = date;
        this.time = time;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMaintitle() {
        return maintitle;
    }

    public void setMaintitle(String maintitle) {
        this.maintitle = maintitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
