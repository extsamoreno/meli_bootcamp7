package com.challenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"user_id", "username", "followers"})
public class FollowersResponse {

    @JsonProperty("user_id")
    private Integer userId;
    private String username;
    private List<UserDTO> followers;

    public FollowersResponse(Integer userId, String username, List<UserDTO> followers) {
        this.userId = userId;
        this.username = username;
        this.followers = followers;
    }

    public FollowersResponse() {
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

    public List<UserDTO> getFollowers() {
        return followers;
    }

    public void setFollowers(List<UserDTO> followers) {
        this.followers = followers;
    }
}
