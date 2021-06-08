package com.example.Challenge.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseListFollowedDTO {
    private Integer idUser;
    private String userName;
    private List<UserDTO> listFollowed;
}
