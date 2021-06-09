package com.example.demo.model.DTO;

import com.example.demo.model.User;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class FollowersListDTO {

    private int id;
    private String userName;
    private List<UserDTO> followers = new ArrayList<>();

    public FollowersListDTO(String userName, int id, List<UserDTO> followers) {
        this.userName = userName;
        this.id = id;
        this.followers = followers;

    }

}
