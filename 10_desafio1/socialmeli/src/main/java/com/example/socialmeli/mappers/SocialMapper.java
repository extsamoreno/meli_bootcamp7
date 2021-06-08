package com.example.socialmeli.mappers;

import com.example.socialmeli.dtos.UserDTO;
import com.example.socialmeli.models.User;

public class SocialMapper {

    public static User usserDTOtoModel(UserDTO userDTO){
        User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());

        return user;
    }
}
