package com.meli.socialmeli.service.user;

import com.meli.socialmeli.dto.FollowersCountDTO;
import com.meli.socialmeli.exception.IdNotFoundException;

public interface IUserService {
    void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException;

    FollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException;
}
