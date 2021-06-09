package com.challenge.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"user_id", "username", "followers_count"})
public class FollowersCountResponse {

    @JsonProperty("user_id")
    private Integer userId;
    private String username;
    @JsonProperty("followers_count")
    private Integer followersCount;

    public FollowersCountResponse(Integer userId, String username, Integer followersCount) {
        this.userId = userId;
        this.username = username;
        this.followersCount = followersCount;
    }

    public FollowersCountResponse() {
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

    public Integer getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(Integer followersCount) {
        this.followersCount = followersCount;
    }
}
