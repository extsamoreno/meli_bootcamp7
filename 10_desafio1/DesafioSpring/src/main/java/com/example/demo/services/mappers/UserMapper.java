package com.example.demo.services.mappers;

import com.example.demo.dtos.UserFollowersCountDTO;
import com.example.demo.dtos.UserResponseDTO;
import com.example.demo.model.User;

public class UserMapper {
    public static UserResponseDTO toDTO(User user) {
        return new UserResponseDTO(user.getUserId(), user.getUserName());
    }
    public static UserFollowersCountDTO toDTOUserFollowersCountDTO(User user){
        return new UserFollowersCountDTO(user.getUserId(), user.getUserName(),user.getFollowed().size());
    }
}