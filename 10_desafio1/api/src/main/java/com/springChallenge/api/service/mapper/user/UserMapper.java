package com.springChallenge.api.service.mapper.user;

import com.springChallenge.api.controller.dto.user.UserDTO;
import com.springChallenge.api.repository.entity.User;

import java.util.ArrayList;

public class UserMapper {
    public static UserDTO[] mapToDTOList(ArrayList<User> users) {
        return users
                .stream()
                .map(UserMapper::mapToDTO)
                .toArray(UserDTO[]::new);
    }

    public static UserDTO mapToDTO(User user){
        return new UserDTO(user.getUserId(), user.getUserName());
    }
}