package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class FollowersDTO extends UserDTO {

    private List<UserDTO> followers;

    public FollowersDTO(int userID, String userName, List<UserDTO> followers){
        super(userID,userName);
        this.setUserID(userID);
        this.setFollowers(followers);
    }
}
