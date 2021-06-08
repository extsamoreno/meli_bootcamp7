package com.example.demo.model;

import com.example.demo.model.DTO.UserDTO;
import lombok.*;

import java.util.List;

@Data
public class User {

    private int id;
    private String userName;
    private int followersCount;
    private List<UserDTO> followers;
    private List<UserDTO> followed;

    public User (int id, String userName, List<UserDTO> followers){
        this.id = id;
        this.userName = userName;
        this.followersCount = followers.size();
    }
}
