package com.desafiospring.socialMeli.service.mapper;

import com.desafiospring.socialMeli.dto.UserDTO;
import com.desafiospring.socialMeli.model.User;

public class UserMapper {

    public static UserDTO toDto(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }


    public static User toUser(UserDTO userDTO) {
        return new User(userDTO.getUserId());
    }

}
