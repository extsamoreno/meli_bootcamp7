package com.example.MeliSocialApi.project.service.dto;

import com.example.MeliSocialApi.project.model.User;
import lombok.Getter;

@Getter
public class UserFollowersCountDTOResponse extends UserDTOResponse{
    private int followers_count;
    public UserFollowersCountDTOResponse(User user, int followers_count){
        super(user.getId(),user.getName());
        this.followers_count = followers_count;
    }
}
