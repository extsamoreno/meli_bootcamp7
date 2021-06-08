package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.UserDTO;
import com.meli.desafio1.web.model.User;

public class UserMapper {
    public UserDTO ModeltoDTO(User user){
        return new UserDTO(user.getUserId(), user.getUserName());
    }
}
