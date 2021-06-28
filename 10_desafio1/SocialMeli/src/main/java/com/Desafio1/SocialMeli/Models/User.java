package com.Desafio1.SocialMeli.Models;

import com.Desafio1.SocialMeli.DTOS.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int userId;
    private String userName;
    private boolean isSeller;
    private List<UserDTO> followers = new ArrayList<>();
    private List<UserDTO> followed = new ArrayList<>();
    private List<Post> posts = new ArrayList<>();
}
