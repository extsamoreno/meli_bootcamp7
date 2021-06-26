package com.meli.SocialMeli.models;

import com.meli.SocialMeli.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int idUser;
    private String userName;
    private boolean esVendedor = false;
    private List<UserDTO> follower = new ArrayList<>();
    private List<UserDTO> followed = new ArrayList<>();
}
