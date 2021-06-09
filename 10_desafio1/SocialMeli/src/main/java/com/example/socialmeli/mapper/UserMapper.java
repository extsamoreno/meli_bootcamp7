package com.example.socialmeli.mapper;

import com.example.socialmeli.DTO.UserDTO;
import com.example.socialmeli.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserDTO dto){
        User model = new User();
        model.setUserId(dto.getUserId());
        model.setUserName(dto.getUserName());
        return model;
    }
    public UserDTO toUserDTO(User model){
        UserDTO dto = new UserDTO();
        dto.setUserId(model.getUserId());
        dto.setUserName(model.getUserName());
        return dto;
    }
}
