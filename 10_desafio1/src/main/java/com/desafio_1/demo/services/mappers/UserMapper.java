package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.UserDTO;
import com.desafio_1.demo.dtos.UserResponseDTO;
import com.desafio_1.demo.models.User;

import java.util.ArrayList;

public class UserMapper {

    public static UserDTO toDTO(User user){
        return new UserDTO(user.getId(),user.getName(), arrayUserToDTO(user.getFollowers()), arrayUserToDTO(user.getFollowed()));
    }

    private static ArrayList<UserDTO> arrayUserToDTO(ArrayList<User> users){
        ArrayList<UserDTO> usersDTO = new ArrayList<>();
        for (User user: users) {
            usersDTO.add(new UserDTO(user.getId(), user.getName()));
        }
        return usersDTO;
    }
}
