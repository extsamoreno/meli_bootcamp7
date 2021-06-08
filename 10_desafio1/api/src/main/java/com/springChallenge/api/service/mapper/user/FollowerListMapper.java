package com.springChallenge.api.service.mapper.user;

import com.springChallenge.api.controller.dto.user.FollowerListDTO;
import com.springChallenge.api.repository.entity.User;

public class FollowerListMapper {

    public static FollowerListDTO mapToDTO(User user) {
        return new FollowerListDTO(user.getUserId(), user.getUserName(), UserMapper.mapToDTOList(user.getFollowers()));
    }
}
