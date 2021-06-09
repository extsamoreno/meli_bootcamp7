package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.UserFollowedDTO;
import com.desafio_1.demo.dtos.UserResponseDTO;
import com.desafio_1.demo.models.User;

import java.util.ArrayList;

public class UserFollowedMapper {

    public static UserFollowedDTO toDTO(User user){
        return new UserFollowedDTO(user.getId(),user.getUserName(), arrayUserToDTO(user.getFollowed()));
    }

    private static ArrayList<UserResponseDTO> arrayUserToDTO(ArrayList<User> users){
        ArrayList<UserResponseDTO> usersDTO = new ArrayList<>();
        for (User user: users) {
            usersDTO.add(new UserResponseDTO(user.getId(), user.getUserName()));
        }
        return usersDTO;
    }
}
