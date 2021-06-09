package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.dtos.UserResponseDTO;
import com.desafio_1.demo.models.User;

import java.util.ArrayList;

public class UserFollowerMapper {

    public static UserFollowerDTO toDTO(User user, ArrayList<User> followers){
        return new UserFollowerDTO(user.getId(), user.getUserName(),arrayUserToDTO(followers));
    }

    private static ArrayList<UserResponseDTO> arrayUserToDTO(ArrayList<User> users){
        ArrayList<UserResponseDTO> usersDTO = new ArrayList<>();
        for (User user: users) {
            usersDTO.add(new UserResponseDTO(user.getId(), user.getUserName()));
        }
        return usersDTO;
    }

}
