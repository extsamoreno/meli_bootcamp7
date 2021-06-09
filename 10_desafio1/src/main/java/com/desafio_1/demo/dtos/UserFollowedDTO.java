package com.desafio_1.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowedDTO extends UserResponseDTO{
    private ArrayList<UserResponseDTO> followed;

    public UserFollowedDTO(int id, String userName) {
        super(id, userName);
    }

    public UserFollowedDTO(int id, String userName, ArrayList<UserResponseDTO> followed) {
        super(id, userName);
        this.followed = followed;
    }
}
