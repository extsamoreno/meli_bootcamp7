package com.desafiospring.socialMeli.service.mapper;

import com.desafiospring.socialMeli.dto.UserDTO;
import com.desafiospring.socialMeli.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDTO toDto(User user) {
        return new UserDTO(user.getUserId(), user.getUserName());
    }

    public static List<UserDTO> toDTOList(List<User> users) {
        List<UserDTO> dtos = new ArrayList<>();
        users.forEach(u -> {
            UserDTO dto = new UserDTO();
            dto.setUserName(u.getUserName());
            dto.setUserId(u.getUserId());
            dtos.add(dto);
        });
        return dtos;
    }

}
