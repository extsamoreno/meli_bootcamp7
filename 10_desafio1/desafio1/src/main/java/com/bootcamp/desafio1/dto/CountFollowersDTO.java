package com.bootcamp.desafio1.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CountFollowersDTO extends UserDTO{

    private int followers_count;

    public CountFollowersDTO(int userId, String userName, int followers_count) {
        super(userId, userName);
        this.followers_count = followers_count;
    }
}
