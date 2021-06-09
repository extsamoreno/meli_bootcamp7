package com.SocialMeli.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class FollowUserDTO extends UserResponseDTO{
    private ArrayList<UserResponseDTO> followed;

    public FollowUserDTO(Integer id, String userName) {
        super(id, userName);
    }

    public FollowUserDTO(Integer id, String userName, ArrayList<UserResponseDTO> followed) {
        super(id, userName);
        this.followed = followed;
    }
}