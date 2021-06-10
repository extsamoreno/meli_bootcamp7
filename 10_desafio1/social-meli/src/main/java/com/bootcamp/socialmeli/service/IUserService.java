package com.bootcamp.socialmeli.service;

import com.bootcamp.socialmeli.DTO.response.UserAmountFollowersDTOres;
import com.bootcamp.socialmeli.DTO.response.UserFollowedListDTOres;
import com.bootcamp.socialmeli.DTO.response.UserFollowersListDTOres;
import com.bootcamp.socialmeli.exception.FollowYourselfException;
import com.bootcamp.socialmeli.exception.UnfollowYourselfException;
import com.bootcamp.socialmeli.exception.UserIdNotFoundException;
import com.bootcamp.socialmeli.model.User;

import java.util.List;

public interface IUserService {
    void follow(Integer userId, Integer userIdToFollow) throws UserIdNotFoundException, FollowYourselfException;

    List<User> getAllUsers();

    UserAmountFollowersDTOres getAmountUserFollowers(Integer id) throws UserIdNotFoundException;

    UserFollowersListDTOres getListUserFollowers(Integer id) throws UserIdNotFoundException;

    UserFollowedListDTOres getListUserFollowed(Integer id) throws UserIdNotFoundException;

    void unfollow(Integer userId, Integer userIdToUnfollow) throws UnfollowYourselfException, UserIdNotFoundException;
}
