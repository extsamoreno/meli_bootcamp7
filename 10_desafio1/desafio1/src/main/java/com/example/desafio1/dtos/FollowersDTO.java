package com.example.desafio1.dtos;

import com.example.desafio1.models.MeliUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowersDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followers;
}
