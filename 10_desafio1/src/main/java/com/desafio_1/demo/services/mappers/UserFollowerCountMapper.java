package com.desafio_1.demo.services.mappers;

import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.models.User;

public class UserFollowerCountMapper {
    public static UserFollowerCountDTO toDTO(User user, Integer followersCount){
        return new UserFollowerCountDTO(user.getId(), user.getUserName(), followersCount);
    }
}
