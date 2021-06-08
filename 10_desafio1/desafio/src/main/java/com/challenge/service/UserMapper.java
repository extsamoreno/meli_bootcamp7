package com.challenge.service;

import com.challenge.dto.UserDTO;
import com.challenge.entity.User;
import org.apache.catalina.LifecycleState;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static List<UserDTO> toDTOList(List<User> users) {
        List<UserDTO> dtos = new ArrayList<>();
        users.forEach(u -> {
            UserDTO dto = new UserDTO();
            dto.setUsername(u.getUsername());
            dto.setUserId(u.getUserId());
            dtos.add(dto);
        });
        return dtos;
    }

}
