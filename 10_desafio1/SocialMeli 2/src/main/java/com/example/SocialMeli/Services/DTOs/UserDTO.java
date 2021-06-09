package com.example.SocialMeli.Services.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    private int userID;
    private String userName;
    private List<Integer> followers;
    private List<Integer> following;
}
