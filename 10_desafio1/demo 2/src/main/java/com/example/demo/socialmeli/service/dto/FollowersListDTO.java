package com.example.demo.socialmeli.service.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class FollowersListDTO {
    private int userId;
    private String userName;
    private ArrayList<UserDTO> followers;
}
