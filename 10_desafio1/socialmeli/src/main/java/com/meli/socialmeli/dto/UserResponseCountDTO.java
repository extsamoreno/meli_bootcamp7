package com.meli.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseCountDTO {
    private int userId;
    private String UserName;
    private int followersCount;

    public UserResponseCountDTO(int userId, String userName) {
        this.userId = userId;
        UserName = userName;
    }
}