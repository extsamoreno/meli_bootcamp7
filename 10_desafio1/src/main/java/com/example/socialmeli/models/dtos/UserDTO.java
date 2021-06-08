package com.example.socialmeli.models.dtos;

import com.example.socialmeli.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class UserDTO {
    private int userId;
    private String userName;

    public UserDTO(User user) {
        this.userId = user.getUserId();
        this.userName = user.getUserName();
    }
}
