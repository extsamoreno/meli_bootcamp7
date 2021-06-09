package com.challenge.dto;

import com.challenge.entity.Post;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    @JsonProperty("user_id")
    private Integer userId;
    private String username;
    private List<Post> posts;
    private List<UserDTO> follows;

    public UserDTO(Integer userId, String username, List<Post> posts, List<UserDTO> follows) {
        this.userId = userId;
        this.username = username;
        this.posts = posts;
        this.follows = follows;
    }

    public UserDTO() {
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

    public List<UserDTO> getFollows() {
        return follows;
    }

    public void setFollows(List<UserDTO> follows) {
        this.follows = follows;
    }
}
