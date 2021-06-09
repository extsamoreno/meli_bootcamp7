package com.desafiospring.socialMeli.dto;


import com.desafiospring.socialMeli.model.User;
import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
public class UserDTO {

    private int userId;
    private String userName;

    public UserDTO(int userId) {
    }

    public UserDTO(int userId, String userName, List<User> followed, List<User> followedBy) {
    }
}
