package com.spring.desafioSpring.Services.Mappers;

import com.spring.desafioSpring.DTOs.CountUserFollowersDTO;
import com.spring.desafioSpring.DTOs.FollowersUserDTO;
import com.spring.desafioSpring.DTOs.UserDTO;
import com.spring.desafioSpring.DTOs.UserIdNameDTO;
import com.spring.desafioSpring.Models.User;

import java.util.ArrayList;

public class UserMapper {

    public static UserIdNameDTO userToUserIdNameDTO(User user){
        UserIdNameDTO dto = new UserIdNameDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        return dto;
    }

    public static UserDTO userToUserDTO(User user){
        UserDTO dto = new UserDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        dto.setFollowers(new ArrayList<>());
        dto.setFollowed(new ArrayList<>());

        for (User u : user.getFollowers())
            dto.getFollowers().add(userToUserIdNameDTO(u));

        for (User u : user.getFollowed())
            dto.getFollowed().add(userToUserIdNameDTO(u));

        return dto;
    }

}
