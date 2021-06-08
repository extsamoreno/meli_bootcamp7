package com.example.demo.Services.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCountFollowersDTO {

    private int userId;
    private String userName;
    private int follower_count;
}
