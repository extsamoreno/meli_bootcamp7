package com.reto1.demo.Model.DTO.Mapper;

import com.reto1.demo.Model.DTO.UserDTO;
import com.reto1.demo.Model.User;

public class UserMapper {

    public static UserDTO toUserDTO(User user){
        return new UserDTO(user.getId(), user.getName(), user.getFollowers().size());
    }
}
