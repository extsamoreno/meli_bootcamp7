package com.example.demo.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FollowedListDTO extends UserDTO{

    private List<UserDTO> followed;

    public FollowedListDTO(UserDTO user){
        this.setUserId(user.getUserId());
        this.setUserName(user.getUserName());
        this.followed = new ArrayList<>();
    }
}
