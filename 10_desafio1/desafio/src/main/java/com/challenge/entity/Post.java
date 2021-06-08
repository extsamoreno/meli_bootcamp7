package com.challenge.entity;

import java.time.LocalDate;

public class Post {

    private Integer postId;
    private LocalDate date;
    private PostDetail detail;
    private Integer userId;


    public Post(Integer postId, LocalDate date, PostDetail detail, Integer userId) {
        this.postId = postId;
        this.date = date;
        this.detail = detail;
        this.userId = userId;
    }

    public Post() {
    }

    public Integer getPostId() {
        return postId;
    }

    public void setPostId(Integer postId) {
        this.postId = postId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public PostDetail getDetail() {
        return detail;
    }

    public void setDetail(PostDetail detail) {
        this.detail = detail;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
