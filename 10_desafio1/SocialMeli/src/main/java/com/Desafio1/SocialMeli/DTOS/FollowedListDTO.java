package com.Desafio1.SocialMeli.DTOS;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedListDTO {
    private int userId;
    private String nameUser;
    private List<UserDTO> followed = new ArrayList<>();
}
