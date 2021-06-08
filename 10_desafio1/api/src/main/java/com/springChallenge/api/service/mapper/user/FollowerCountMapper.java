package com.springChallenge.api.service.mapper.user;

import com.springChallenge.api.controller.dto.user.FollowerCountDTO;
import com.springChallenge.api.repository.entity.User;

public class FollowerCountMapper {

    public static FollowerCountDTO mapToDTO(User user) {
        return new FollowerCountDTO(user.getUserId(), user.getUserName(), user.getFollowers().size());
    }
}
