package com.example.Challenge.service;

import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;

public interface IUserService {
    void Follow(Integer userId, Integer userToFollow);
    UserResponseCountDTO getUserFollowersCount(Integer userId);
    UserResponseListDTO getUserFollowersList(Integer userId);
    UserResponseListFollowedDTO getUserFollowedList(Integer userId);
}
