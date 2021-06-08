package com.example.DesafioSpring.services.mapper;

import com.example.DesafioSpring.dto.UserDTO;
import com.example.DesafioSpring.models.User;

public class UserMapper {
    public static UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getName());
    }

    public static User toUser(UserDTO user){
        return new User();
    }
}
