package com.example.demo.services;

import com.example.demo.DTO.FollowersCountDTO;
import com.example.demo.DTO.FollowersListDTO;
import com.example.demo.DTO.UserDTO;
import com.example.demo.exception.UserNotFoundException;

public interface IUserServices {
    void follow(Integer userId, Integer userIdToFollow) throws UserNotFoundException;

    FollowersCountDTO countFollowers(Integer userId) throws UserNotFoundException;

    FollowersListDTO followersList (Integer userId) throws UserNotFoundException;
}
