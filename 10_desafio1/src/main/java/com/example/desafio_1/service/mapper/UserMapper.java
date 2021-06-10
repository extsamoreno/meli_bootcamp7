package com.example.desafio_1.service.mapper;

import com.example.desafio_1.models.User;
import com.example.desafio_1.service.dto.UserDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserMapper implements IGenericMapper<User, UserDTO, Object> {
    @Override
    public UserDTO toDto(User model) {
        return new UserDTO(model.getId(), model.getName());
    }

    @Override
    public User toModel(UserDTO dto) {
        return null;
    }

    @Override
    public Object toDtoResponse(User model) {
        return null;
    }
}
