package com.bootcamp.desafio1.service;

import com.bootcamp.desafio1.dto.CountFollowersDTO;
import com.bootcamp.desafio1.dto.FollowedListDTO;
import com.bootcamp.desafio1.dto.FollowersListDTO;
import com.bootcamp.desafio1.dto.UserDTO;
import com.bootcamp.desafio1.model.User;

import java.util.ArrayList;

public abstract class Mapper {

    public static UserDTO toUserDTO(User user){
        return new UserDTO(user.getUserId(), user.getUserName());
    }

    public static CountFollowersDTO toCountFollowersDTO(User user, int followers_count){
        return new CountFollowersDTO(user.getUserId(), user.getUserName(), followers_count);
    }

    public static FollowersListDTO toFollowersListDTO(User user, ArrayList<UserDTO> followers){
        return new FollowersListDTO(user.getUserId(), user.getUserName(), followers);
    }


    public static FollowedListDTO toFollowedListDTO(User user, ArrayList<UserDTO> followed){
        return new FollowedListDTO(user.getUserId(), user.getUserName(), followed);
    }
}
