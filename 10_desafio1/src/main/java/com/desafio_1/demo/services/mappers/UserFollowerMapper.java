package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.UserDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.models.User;

import java.util.ArrayList;

public class UserFollowerMapper {

    public static UserFollowerDTO toDTO(User user){
        return new UserFollowerDTO(user.getId(), user.getUserName(),arrayUserToDTO(user.getFollowers()));
    }

    private static ArrayList<UserFollowerDTO> arrayUserToDTO(ArrayList<User> users){
        ArrayList<UserFollowerDTO> usersDTO = new ArrayList<>();
        for (User user: users) {
            usersDTO.add(new UserFollowerDTO(user.getId(), user.getUserName()));
        }
        return usersDTO;
    }

}
