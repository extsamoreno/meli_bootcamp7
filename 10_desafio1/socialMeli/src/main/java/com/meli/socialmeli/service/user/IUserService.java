package com.meli.socialmeli.service.user;

import com.meli.socialmeli.dto.UserWithFollowedDTO;
import com.meli.socialmeli.dto.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.UserWithFollowersDTO;
import com.meli.socialmeli.exception.CanNotFollowException;
import com.meli.socialmeli.exception.IdNotFoundException;

public interface IUserService {

    void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException, CanNotFollowException;

    UserWithFollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException;

    UserWithFollowersDTO followersOf(Integer userId) throws IdNotFoundException;

    UserWithFollowedDTO followedOf(Integer userId) throws IdNotFoundException;
}
