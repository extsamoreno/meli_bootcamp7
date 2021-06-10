package com.meli.demo.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor@NoArgsConstructor
public class LisUsersResponseDTO {

    private int userId;
    private String userName;
    private ArrayList<UserDTO> followers;
}
