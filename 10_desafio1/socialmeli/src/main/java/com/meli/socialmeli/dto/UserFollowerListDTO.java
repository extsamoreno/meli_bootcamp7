package com.meli.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserFollowerListDTO {

    private int userId;
    private String UserName;
    private ArrayList<UserResponseDTO> followers;
}
