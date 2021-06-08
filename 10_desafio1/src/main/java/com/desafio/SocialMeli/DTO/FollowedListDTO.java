package com.desafio.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowedListDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followed;
}
