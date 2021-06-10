package com.meli.desafio.users.mappers;

import com.meli.desafio.users.models.User;
import com.meli.desafio.users.models.dto.ResponseUserCountFollowers;
import com.meli.desafio.users.models.dto.ResponseUserListFollowed;
import com.meli.desafio.users.models.dto.ResponseUserListFollowers;
import com.meli.desafio.users.models.dto.UserDTO;

import java.util.List;

public class UserMapper {
    public static UserDTO userToDTO(User user){
        return UserDTO.builder()
                .userName(user.getUserName())
                .id(user.getId())
                .build();
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

    public static ResponseUserListFollowed userToUserWithFollowed(User user, List<UserDTO> listUserDTo) {
        return ResponseUserListFollowed.builder()
                .id(user.getId())
                .userName(user.getUserName())
                .followed(listUserDTo)
                .build();
    }
}
