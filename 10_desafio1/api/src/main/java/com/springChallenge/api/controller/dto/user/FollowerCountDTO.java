package com.springChallenge.api.controller.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class FollowerCountDTO extends UserDTO{
    @JsonProperty("followers_count")
    private int followersCount;

    public FollowerCountDTO(Integer userId, String userName, Integer followersCount){
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
