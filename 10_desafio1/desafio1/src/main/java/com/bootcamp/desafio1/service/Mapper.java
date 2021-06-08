package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.CountFollowersDTO;
import com.bootcamp.desafio1.dto.UserDTO;
import com.bootcamp.desafio1.model.User;

public abstract class Mapper {

    public static UserDTO toUserDTO(User user){
        return new UserDTO(user.getUserId(), user.getUserName());
    }

    public static CountFollowersDTO toCountFollowersDTO(User user, int followers_count){
        return new CountFollowersDTO(user.getUserId(), user.getUserName(), followers_count);
    }
}
