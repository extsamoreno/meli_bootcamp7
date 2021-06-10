package com.example.Challenge.mapper;

import com.example.Challenge.dto.UserDTO;
import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;
import com.example.Challenge.model.User;

public class MapperUser {

    //Convert User to  UserResponseCountDTO
    public static UserResponseCountDTO toUserResponseCountDTO(User user){
        UserResponseCountDTO userResult = new UserResponseCountDTO(user.getIdUser(), user.getUserName(), user.getFollowers().size());
        return userResult;
    }
    //Convert User to  UserResponseListtDTO
    public static UserResponseListDTO toUserResponseListDTO(User user){
        UserResponseListDTO userListResult = new UserResponseListDTO(user.getIdUser(), user.getUserName(), user.getFollowers());
        return userListResult;
    }
    //Convert User to  UserDTO
    public static UserDTO toUserDTO(User user){
        UserDTO userResult = new UserDTO(user.getIdUser(), user.getUserName());
        return userResult;
    }
    //Convert User to  UserResponseListFollowedDTO
    public static UserResponseListFollowedDTO toUserFollowedResponseListDTO(User user){
        UserResponseListFollowedDTO userListResult = new UserResponseListFollowedDTO(user.getIdUser(), user.getUserName(), user.getFollowed());
        return userListResult;
    }
}
