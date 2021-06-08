package com.desafio.socialMeli.service.mapper;

import com.desafio.socialMeli.repository.entities.User;
import com.desafio.socialMeli.service.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {
    public static UserDTO toDTO(User user, ArrayList<User> userList){
        return new UserDTO(user.getName(), userList);
    }

    public static UserDTO toDTO(User user){
        System.out.println("el username es: " +user.getName());
        return new UserDTO(user.getName(), new ArrayList<User>() {});
    }
}
