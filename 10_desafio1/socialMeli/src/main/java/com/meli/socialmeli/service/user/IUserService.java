package com.meli.socialmeli.service.user;

import com.meli.socialmeli.domain.User;
import com.meli.socialmeli.dto.user.UserWithFollowedDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersCountDTO;
import com.meli.socialmeli.dto.user.UserWithFollowersDTO;
import com.meli.socialmeli.exception.FollowException;
import com.meli.socialmeli.exception.IdNotFoundException;
import com.meli.socialmeli.service.orderType.UserOrderType;

public interface IUserService {

    void followUser(Integer userId, Integer userIdToFollow) throws IdNotFoundException, FollowException;

    UserWithFollowersCountDTO followersCountOf(Integer userId) throws IdNotFoundException;

    UserWithFollowersDTO followersOf(Integer userId, UserOrderType order) throws IdNotFoundException;

    UserWithFollowedDTO followedOf(Integer userId, UserOrderType order) throws IdNotFoundException;

    void unfollowUser(Integer userId, Integer userIdToUnfollow) throws IdNotFoundException, FollowException;

    User getValidUserById(Integer userId) throws IdNotFoundException;

}
