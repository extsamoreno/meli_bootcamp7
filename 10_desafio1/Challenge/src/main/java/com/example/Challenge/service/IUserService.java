package com.example.Challenge.service;

import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;
import com.example.Challenge.exception.UserException;
import com.example.Challenge.exception.UserIdNotFoundException;

public interface IUserService {
    void Follow(Integer userId, Integer userToFollow) throws UserIdNotFoundException;
    UserResponseCountDTO getUserFollowersCount(Integer userId);
    UserResponseListDTO getUserFollowersList(Integer userId, String order);
    UserResponseListFollowedDTO getUserFollowedList(Integer userId, String order);
    void Unfollow (Integer userId, Integer userToUnfollow);
}
