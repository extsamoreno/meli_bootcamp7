package com.desafio_1.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFollowerDTO extends UserResponseDTO{
    private ArrayList<UserResponseDTO> followers;

    public UserFollowerDTO(int id, String userName, ArrayList<UserResponseDTO> followers) {
        super(id, userName);
        this.followers = followers;
    }
}
