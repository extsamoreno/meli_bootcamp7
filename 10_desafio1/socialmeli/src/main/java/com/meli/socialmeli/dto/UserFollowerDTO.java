package com.meli.socialmeli.dto;

import com.meli.socialmeli.model.UserMeli;
import lombok.AllArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
public class UserFollowerDTO {
    private int userId;
    private String UserName;
    private ArrayList<UserResponseDTO> followers;

}
