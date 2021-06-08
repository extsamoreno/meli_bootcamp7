package com.meli.socialmeli.mapper;

import com.meli.socialmeli.dto.UserResponseDTO;
import com.meli.socialmeli.model.UserMeli;

public class UserMapper {
    public static UserResponseDTO toDTO(UserMeli userMeli){
        return new UserResponseDTO(userMeli.getUserId(), userMeli.getUserName());
    }


}
