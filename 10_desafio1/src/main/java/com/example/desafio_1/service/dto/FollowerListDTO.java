package com.example.desafio_1.service.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FollowerListDTO extends UserDataBase {
    private List<UserDTO> followers;

    public FollowerListDTO(int userId, String userName, List<UserDTO> followers) {
        super(userId, userName);
        this.followers = followers;
    }
}
