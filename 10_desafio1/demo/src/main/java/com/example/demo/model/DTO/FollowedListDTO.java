package com.example.demo.model.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FollowedListDTO {
    private int id;
    private String userName;
    private List<UserDTO> followed = new ArrayList<>();

    public FollowedListDTO(String userName, int id, List<UserDTO> followers) {
        this.userName = userName;
        this.id = id;
        this.followed = followers;

    }
}
