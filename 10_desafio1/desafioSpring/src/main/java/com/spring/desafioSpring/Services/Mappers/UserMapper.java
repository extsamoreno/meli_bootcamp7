package com.spring.desafioSpring.Services.Mappers;

import com.spring.desafioSpring.DTOs.CountUserFollowersDTO;
import com.spring.desafioSpring.DTOs.FollowersUserDTO;
import com.spring.desafioSpring.DTOs.UserIdNameDTO;
import com.spring.desafioSpring.Models.User;

public class UserMapper {

    public static UserIdNameDTO userToUserIdNameDTO(User user){
        UserIdNameDTO dto = new UserIdNameDTO();
        dto.setUserId(user.getUserId());
        dto.setUserName(user.getUserName());
        return dto;
    }

}
