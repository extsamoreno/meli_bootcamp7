package com.SocialMeli.dtos;

import lombok.Data;

@Data
public class UserDTO {
    int userId;
    String userName;

    public UserDTO(int userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }
}