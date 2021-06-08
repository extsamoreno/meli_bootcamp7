package com.meli.desafio.mappers;

import com.meli.desafio.models.User;
import com.meli.desafio.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.models.dto.ResponseUserListFollowers;
import com.meli.desafio.models.dto.UserDTO;

public class UserMapper {
    public static UserDTO userToDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setUserName(user.getUserName());
        userDTO.setId(user.getId());
        return userDTO;
    }

    public static ResponseUserCountFollowers userToResponse(User user){
        return ResponseUserCountFollowers.builder()
                .userName(user.getUserName())
                .id(user.getId())
                .followersCount(user.getFollowed().size())
                .build();
    }

    public static ResponseUserListFollowers userToResponseList(User user){
        return ResponseUserListFollowers.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .build();
    }
}
