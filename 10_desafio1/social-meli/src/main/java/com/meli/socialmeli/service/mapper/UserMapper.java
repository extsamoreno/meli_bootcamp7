package com.meli.socialmeli.service.mapper;

import com.meli.socialmeli.dto.user.UserDTO;
import com.meli.socialmeli.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {
    public static UserDTO toUserDTO(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }

    public static List<UserDTO> toUsersDTO(List<User> users) {
        return users.stream().map(UserMapper::toUserDTO).collect(Collectors.toList());
    }
}
