package com.example.desafiospring.socialmeli.service.mapper;

import com.example.desafiospring.socialmeli.model.User;
import com.example.desafiospring.socialmeli.service.DTO.UserFollowDTO;

public class UserMapper {
    public static UserFollowDTO getUserFollowDTO(User user){
        return new UserFollowDTO(user.getUserId(), user.getUserName());
    }
}
