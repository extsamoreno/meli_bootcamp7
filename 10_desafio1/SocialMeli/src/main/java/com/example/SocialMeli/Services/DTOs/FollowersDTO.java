package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class FollowersDTO extends Followment {

    private List<UserDTO> followers;

    public FollowersDTO(String userID, String userName, List<UserDTO> followers){
        super(userID,userName);
        this.setUserId(userID);
        this.setFollowers(followers);
    }
}
