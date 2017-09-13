package com.darengj.jddata.beans;

import java.util.Date;

/**
 * Created by Tony on 2017/8/8.
 */
public class Album {
    private int id;
    private String data_id;
    private String title;
    private String sub_title;
    private String author;
    private int like_num;
    private String cover_pic;
    private String link;
    private String fetch_time;
    private String publish_time;
    public String getPublish_time() {
        return publish_time;
    }
    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSub_title() {
        return sub_title;
    }

    public void setSub_title(String sub_title) {
        this.sub_title = sub_title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLike_num() {
        return like_num;
    }

    public void setLike_num(int like_num) {
        this.like_num = like_num;
    }

    public String getCover_pic() {
        return cover_pic;
    }

    public void setCover_pic(String cover_pic) {
        this.cover_pic = cover_pic;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getFetch_time() {
        return fetch_time;
    }

    public void setFetch_time(String fetch_time) {
        this.fetch_time = fetch_time;
    }
}
