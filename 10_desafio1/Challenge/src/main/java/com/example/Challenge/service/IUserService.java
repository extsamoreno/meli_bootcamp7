package com.example.Challenge.service;

import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;

public interface IUserService {
    void Follow(Integer userId, Integer userToFollow);
    UserResponseCountDTO getUserFollowersCount(Integer userId);
    UserResponseListDTO getUserFollowersList(Integer userId);
}
