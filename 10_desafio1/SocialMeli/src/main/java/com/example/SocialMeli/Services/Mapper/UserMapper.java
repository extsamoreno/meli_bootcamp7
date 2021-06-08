package com.example.SocialMeli.Services.Mapper;


import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.UserDTO;

public class UserMapper {

    public static UserDTO toDTO(User user){
        return new UserDTO(user.getId(), user.getName());
    }

    public static User toUser(UserDTO user){
        return new User();
    }
}
