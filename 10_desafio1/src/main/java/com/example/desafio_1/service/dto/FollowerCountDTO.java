package com.example.desafio_1.service.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowerCountDTO extends UserDataBase {
    private int followers_count;
    public FollowerCountDTO(int userId, String userName, int followers_count) {
        super(userId, userName);
        this.followers_count = followers_count;
    }
}
