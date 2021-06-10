package com.example.desafio1.mappers;

import com.example.desafio1.dtos.UserDTO;
import com.example.desafio1.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static UserDTO userToDTO(User user) {
        return new UserDTO(user);
    }

    public static User dtoToUser(UserDTO userDTO) {
        return new User(userDTO);
    }

    public static List<UserDTO> listUserToListUserDTO(List<User> users) {
        List<UserDTO> listDTO = new ArrayList<>();
        for(User u : users) {
            listDTO.add(userToDTO(u));
        }
        return listDTO;
    }
}
