package com.example.desafio1.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseCountFollowersDTO {

    private int userId;
    private String userName;
    private int followersCount;
}
