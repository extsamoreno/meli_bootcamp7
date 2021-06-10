package com.meli.socialmeli.service.user;

import com.meli.socialmeli.dto.user.FollowersCountDTO;
import com.meli.socialmeli.dto.user.UserFollowedDTO;
import com.meli.socialmeli.dto.user.UserFollowersDTO;
import com.meli.socialmeli.exception.UserAlreadyFollowedException;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import com.meli.socialmeli.exception.UserNotFollowedException;

public interface IUserService {
    void followUser(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowedException;
    FollowersCountDTO getFollowersCount(Integer userId) throws UserIdNotFoundException;
    UserFollowersDTO getUserFollowers(Integer userId, String order) throws UserIdNotFoundException;
    UserFollowedDTO getUserFollowed(Integer userId, String order) throws UserIdNotFoundException;
    void unfollowUser(Integer userId, Integer userIdToUnfollow) throws UserIdNotFoundException, UserNotFollowedException;
}
