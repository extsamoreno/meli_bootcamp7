package com.example.SocialMeli.Services.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class FollowCountDTO extends UserDTO {

    private int followers_count;

    public FollowCountDTO(int userId, String userName, int followers_count){

        this.setUserId(userId);
        this.setUserName(userName);
        this.setFollowers_count(followers_count);
    }


}