package com.example.demo.socialmeli.service.dto;

import lombok.Data;

import java.util.ArrayList;
@Data
public class FollowersListDTO extends UserDTO{
    private ArrayList<UserDTO> followers;
}
