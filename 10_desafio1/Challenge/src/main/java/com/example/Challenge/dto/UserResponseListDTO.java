package com.example.Challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseListDTO {
    private Integer idUser;
    private String userName;
    private List<UserDTO> listFollowers;
}
