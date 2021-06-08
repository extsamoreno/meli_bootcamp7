package com.springChallenge.api.service.mapper.user;

import com.springChallenge.api.controller.dto.user.FollowedListDTO;
import com.springChallenge.api.repository.entity.User;

public class FollowedListMapper {

    public static FollowedListDTO mapToDTO(User user) {
        return new FollowedListDTO(user.getUserId(), user.getUserName(), UserMapper.mapToDTOList(user.getSellersFollowed()));
    }
}
