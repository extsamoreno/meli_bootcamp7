package com.meli.socialmeli.service.user;

import com.meli.socialmeli.dto.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.UserWithFollowersDTO;
import com.meli.socialmeli.exception.IdNotFoundException;

public interface IUserService {

    void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException;

    UserWithFollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException;

    UserWithFollowersDTO followersOf(Integer userId) throws IdNotFoundException;
}
