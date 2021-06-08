package com.example.desafio1.mappers;

import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.models.User;

public class UserMapper {

    public static UserDTO UserToDTO(User user) {
        return new UserDTO(user);
    }

    public static User DTOToUser(UserDTO userDTO) {
        return new User(userDTO);
    }
}
