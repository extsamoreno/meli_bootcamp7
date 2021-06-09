package com.example.DesafioSpring.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class FollowersCountDTO extends Following {
    private int followers_count;

    public FollowersCountDTO(int userId, String userName, int followers_count){

        this.setUserId(userId);
        this.setUserName(userName);
        this.setFollowers_count(followers_count);
    }
}
