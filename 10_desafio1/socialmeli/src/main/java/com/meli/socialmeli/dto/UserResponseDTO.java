package com.meli.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserResponseDTO {
    private int userId;
    private String UserName;
    private int followerCount;

    public UserResponseDTO(int userId, String userName) {
        this.userId = userId;
        UserName = userName;
    }
}