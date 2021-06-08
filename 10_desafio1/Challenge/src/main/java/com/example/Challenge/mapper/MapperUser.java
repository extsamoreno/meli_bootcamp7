package com.example.Challenge.mapper;

import com.example.Challenge.dto.UserDTO;
import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.model.User;

public class MapperUser {
    public static UserResponseCountDTO toUserResponseCountDTO(User user){
        UserResponseCountDTO userResult = new UserResponseCountDTO(user.getIdUser(), user.getUserName(), user.getFollowers().size());
        return userResult;
    }
    public static UserResponseListDTO toUserResponseListDTO(User user){
        UserResponseListDTO userListResult = new UserResponseListDTO(user.getIdUser(), user.getUserName(), user.getFollowers());
        return userListResult;
    }
    public static UserDTO toUserDTO(User user){
        UserDTO userResult = new UserDTO(user.getIdUser(), user.getUserName());
        return userResult;
    }
}
