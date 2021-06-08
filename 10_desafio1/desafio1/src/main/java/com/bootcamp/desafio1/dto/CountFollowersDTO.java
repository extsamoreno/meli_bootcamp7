package com.bootcamp.desafio1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountFollowersDTO extends UserDTO{

    private int followersCount;

    public CountFollowersDTO(int userId, String userName, int followersCount) {
        super(userId, userName);
        this.followersCount = followersCount;
    }
}
