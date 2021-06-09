package com.example.demo.services;

import com.example.demo.DTO.*;
import com.example.demo.exception.UserNotFoundException;

public interface IUserServices {
    void follow(Integer userId, Integer userIdToFollow) throws UserNotFoundException;

    FollowersCountDTO countFollowers(Integer userId) throws UserNotFoundException;

    FollowersListDTO followersList (Integer userId) throws UserNotFoundException;

    FollowedListDTO followedList(Integer userID) throws UserNotFoundException;

}
