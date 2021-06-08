package com.challenge.entity;

import com.fasterxml.jackson.annotation.*;


public class User {

    @JsonProperty("user_id")
    private Integer userId;
    private String username;


    public User(Integer userId, String username) {
        this.userId = userId;
        this.username = username;
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

}
