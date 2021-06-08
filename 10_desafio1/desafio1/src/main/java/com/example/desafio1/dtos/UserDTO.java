package com.example.desafio1.dtos;

import com.example.desafio1.models.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int userId;
    private String userName;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
    }
}
