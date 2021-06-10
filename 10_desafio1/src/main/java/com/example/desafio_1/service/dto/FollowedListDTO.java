package com.example.desafio_1.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FollowedListDTO extends UserDataBase {
    private List<UserDTO> followed;

    public FollowedListDTO(int userId, String userName, List<UserDTO> followers) {
        super(userId, userName);
        this.followed = followers;
    }
}
