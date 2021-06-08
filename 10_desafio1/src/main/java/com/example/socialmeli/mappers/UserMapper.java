package com.example.socialmeli.mappers;

import com.example.socialmeli.models.User;
import com.example.socialmeli.models.dtos.UserDTO;

public class UserMapper {
    public static UserDTO UserToDTO(User user) {
        return new UserDTO(user);
    }

    public static User DTOToUser(UserDTO userDTO) {
        return new User(userDTO);
    }
}
