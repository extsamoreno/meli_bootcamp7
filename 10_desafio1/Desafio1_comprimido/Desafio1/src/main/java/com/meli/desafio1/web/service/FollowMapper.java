package com.meli.desafio1.web.service;

import com.meli.desafio1.web.dto.FollowDTO;
import com.meli.desafio1.web.model.Follow;

public class FollowMapper {
    public static FollowDTO toDTO(Follow follow){
        return new FollowDTO(follow.getUserId(), follow.getFollows_id());
    }
}
