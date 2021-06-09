package com.desafio.socialMeli.service.mapper;

import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.UserDTO;
import com.desafio.socialMeli.service.dto.UserFollowersCountDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    /*
    public static UserDTO toUserDTO(User user, ArrayList<User> userList){
        return new UserDTO(user.getName(), userList);
    }*/

    public static UserDTO toUserDTO(User user){
        return new UserDTO(user.getName(), new ArrayList<User>() {}, new ArrayList<User>() {});
    }
}
