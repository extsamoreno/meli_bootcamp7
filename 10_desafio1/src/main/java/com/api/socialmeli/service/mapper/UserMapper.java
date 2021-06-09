package com.api.socialmeli.service.mapper;

import com.api.socialmeli.dto.UserDTO;
import com.api.socialmeli.model.UserModel;

public class UserMapper {

    public static UserDTO userToFollowerDTO (UserModel user){
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        return dto;
    }
}
