package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter @Getter
public class FollowedDTO extends UserDTO {

    private List<UserDTO> followed;

    public FollowedDTO(int userID, String userName, List<UserDTO> followed){
        super(userID,userName);
        this.setUserId(userID);
        this.setFollowed(followed);
    }
}
