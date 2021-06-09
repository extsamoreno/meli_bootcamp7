package com.SocialMeli.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
class FollowerUserDTO {
    private Integer id;
    private String userName;
    private ArrayList<UserResponseDTO> followers;

}
