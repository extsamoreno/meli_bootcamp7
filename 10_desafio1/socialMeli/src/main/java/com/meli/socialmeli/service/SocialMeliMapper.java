package com.meli.socialmeli.service;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.FollowersCountDTO;


public class SocialMeliMapper {

    public static FollowersCountDTO toFollowersCountDTO(User user) {
        Integer count = user.getFollowers().size();
        return new FollowersCountDTO(user.getUserId(), user.getUserName(), count);
    }
}
