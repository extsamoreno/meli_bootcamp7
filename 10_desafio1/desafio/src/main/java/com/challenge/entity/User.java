package com.challenge.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class User {

    @JsonProperty("user_id")
    private Integer userId;
    private String username;
    private List<Post> posts;
    private List<User> follows;

    public User(Integer userId, String username, List<Post> posts, List<User> follows) {
        this.userId = userId;
        this.username = username;
        this.posts = posts;
        this.follows = follows;
    }

    public User() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public List<User> getFollows() {
        return follows;
    }

    public void setFollows(List<User> follows) {
        this.follows = follows;
    }
}
