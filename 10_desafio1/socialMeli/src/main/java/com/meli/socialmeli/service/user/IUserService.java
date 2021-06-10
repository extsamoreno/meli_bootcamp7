package com.meli.socialmeli.service.user;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersDTO;
import com.meli.socialmeli.exception.FollowException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.exception.InvalidSortTypeException;

public interface IUserService {

    void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException, FollowException;

    UserWithFollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException;

    UserWithFollowersDTO followersOf(Integer userId, String order) throws IdNotFoundException, InvalidSortTypeException;

    UserWithFollowedDTO followedOf(Integer userId, String order) throws IdNotFoundException, InvalidSortTypeException;

    void unfollowUser(Integer userId, Integer userIdToUnfollow) throws IdNotFoundException, FollowException;

    User getValidUserById(Integer userId) throws IdNotFoundException;

}
