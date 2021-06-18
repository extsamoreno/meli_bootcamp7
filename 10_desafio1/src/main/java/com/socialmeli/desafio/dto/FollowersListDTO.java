package com.socialmeli.desafio.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public  class FollowersListDTO {

    private int userId;
    private String userName;
    private ArrayList<UserDTO> followers;
}