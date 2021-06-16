package com.desafio.SocialMeli.DTO.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowersListDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followers;
}