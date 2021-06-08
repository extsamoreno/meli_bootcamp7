package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class FollowedDTO extends Followment {

    private List<UserDTO> followed;

    public FollowedDTO(String userID, String userName, List<UserDTO> followed){
        super(userID,userName);
        this.setUserId(userID);
        this.setFollowed(followed);
    }
}
