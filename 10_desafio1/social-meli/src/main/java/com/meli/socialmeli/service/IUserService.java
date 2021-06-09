package com.meli.socialmeli.service;

import com.meli.socialmeli.dto.FollowersCountDTO;
import com.meli.socialmeli.dto.UserFollowedDTO;
import com.meli.socialmeli.dto.UserFollowersDTO;
import com.meli.socialmeli.exception.UserIdNotFoundException;

public interface IUserService {
    void followUser(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException;
    FollowersCountDTO followersCount(Integer userId) throws UserIdNotFoundException;
    UserFollowersDTO userFollowers(Integer userId) throws UserIdNotFoundException;
    UserFollowedDTO userFollowed(Integer userId) throws UserIdNotFoundException;
    void unfollowUser(Integer userId, Integer userIdToUnfollow) throws UserIdNotFoundException;
}
