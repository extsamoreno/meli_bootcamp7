package com.example.SocialMeli.Services.Mapper;


import com.example.SocialMeli.Models.User;
import com.example.SocialMeli.Services.DTOs.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDTO toDTO(User user){

        return new UserDTO(user.getId(), user.getName());
    }
    public static List<UserDTO> toDTOs(List<User> users){

        List<UserDTO> output = new ArrayList<>();
        for (int i = 0; i < users.size(); i++) {

            output.add(toDTO(users.get(i)));

        }
        return output;
    }
    public static User toUser(UserDTO user){
        return new User();
    }
}
