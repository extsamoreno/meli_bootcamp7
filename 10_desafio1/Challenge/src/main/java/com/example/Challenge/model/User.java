package com.example.Challenge.model;

import com.example.Challenge.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer idUser;
    private String userName;
    private boolean isSeller;
    private List<UserDTO> followers;
    private List<UserDTO> followed;

    public User(Integer idUser, String userName, boolean isSeller) {
        this.idUser=idUser;
        this.userName= userName;
        this.isSeller=isSeller;
        this.followers = new ArrayList<UserDTO>();
        this.followed = new ArrayList<UserDTO>();
    }


}
