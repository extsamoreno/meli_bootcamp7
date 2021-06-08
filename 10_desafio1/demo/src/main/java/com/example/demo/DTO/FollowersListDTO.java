package com.example.demo.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FollowersListDTO extends UserDTO{

    private List<UserDTO> followers;

    public FollowersListDTO() {
        this.followers = new ArrayList<>();
    }

    public FollowersListDTO(UserDTO user){
        this.setUserId(user.getUserId());
        this.setUserName(user.getUserName());
        this.followers = new ArrayList<>();
    }
}
