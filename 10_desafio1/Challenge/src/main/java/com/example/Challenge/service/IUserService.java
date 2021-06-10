package com.example.Challenge.service;

import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;
import com.example.Challenge.exception.UserException;
import com.example.Challenge.exception.UserIdNotFoundException;

public interface IUserService {
    void Follow(Integer userId, Integer userToFollow) throws UserException;
    UserResponseCountDTO getUserFollowersCount(Integer userId)  throws UserException;
    UserResponseListDTO getUserFollowersList(Integer userId, String order) throws UserException;
    UserResponseListFollowedDTO getUserFollowedList(Integer userId, String order) throws UserException;
    void Unfollow (Integer userId, Integer userToUnfollow) throws UserException;
}
