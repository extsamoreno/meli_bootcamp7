package com.springChallenge.api.controller.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FollowerCountDTO {
    private int userId;
    private String userName;
    @JsonProperty("followers_count")
    private int followersCount;
}
