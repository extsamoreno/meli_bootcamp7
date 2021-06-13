package com.desafio.socialMeli.model.mapper;

import com.desafio.socialMeli.model.dao.models.User;
import com.desafio.socialMeli.model.dto.UserDTO;

import java.util.ArrayList;

public class UserMapper {
    /*
    public static UserDTO toUserDTO(User user, ArrayList<User> userList){
        return new UserDTO(user.getName(), userList);
    }*/

    public static UserDTO toUserDTO(User user){
        return new UserDTO(user.getName(), new ArrayList<User>() {}, new ArrayList<User>() {});
    }
}
