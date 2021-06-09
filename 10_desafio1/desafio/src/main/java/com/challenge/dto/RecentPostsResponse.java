package com.challenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"user_id", "posts"})
public class RecentPostsResponse {

    @JsonProperty("user_id")
    private Integer userId;
    private List<PostDTO> posts;

    public RecentPostsResponse(Integer userId, List<PostDTO> posts) {
        this.userId = userId;
        this.posts = posts;
    }

    public RecentPostsResponse() {
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
