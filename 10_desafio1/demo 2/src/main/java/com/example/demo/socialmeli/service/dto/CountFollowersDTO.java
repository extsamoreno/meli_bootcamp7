package com.example.demo.socialmeli.service.dto;

import lombok.Data;

@Data
public class CountFollowersDTO {
    private int userId;
    private String userName;
    private int followers_count;
}
