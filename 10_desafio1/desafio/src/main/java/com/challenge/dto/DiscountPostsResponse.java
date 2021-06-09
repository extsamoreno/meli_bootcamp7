package com.challenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"user_id", "username", "posts"})
public class DiscountPostsResponse {

    @JsonProperty("user_id")
    private Integer userId;
    private String username;
    @JsonProperty("posts")
    private List<PostDTO> promoPosts;

    public DiscountPostsResponse(Integer userId, String username, List<PostDTO> promoPosts) {
        this.userId = userId;
        this.username = username;
        this.promoPosts = promoPosts;
    }

    public DiscountPostsResponse() {
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

    public List<PostDTO> getPromoPosts() {
        return promoPosts;
    }

    public void setPromoPosts(List<PostDTO> promoPosts) {
        this.promoPosts = promoPosts;
    }
}
