package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.user.FollowersCountDTO;
import com.meli.socialmeli.dto.user.UserFollowedDTO;
import com.meli.socialmeli.dto.user.UserFollowersDTO;
import com.meli.socialmeli.exception.UserIdNotFoundException;

public interface IUserService {
    void followUser(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException;
    FollowersCountDTO getFollowersCount(Integer userId) throws UserIdNotFoundException;
    UserFollowersDTO getUserFollowers(Integer userId, String order) throws UserIdNotFoundException;
    UserFollowedDTO getUserFollowed(Integer userId, String order) throws UserIdNotFoundException;
    void unfollowUser(Integer userId, Integer userIdToUnfollow) throws UserIdNotFoundException;
}
