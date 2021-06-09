package com.meli.SocialMeli.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private int userId;
    private String userName;
    private List<UserDTO> followers = new ArrayList<>();
    private List<UserDTO> followed = new ArrayList<>();
}
