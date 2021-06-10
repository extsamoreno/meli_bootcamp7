package com.example.Challenge.service;

import com.example.Challenge.dto.UserResponseCountDTO;
import com.example.Challenge.dto.UserResponseListDTO;
import com.example.Challenge.dto.UserResponseListFollowedDTO;
import com.example.Challenge.exception.ProgramException;

public interface IUserService {
    void Follow(Integer userId, Integer userToFollow) throws ProgramException;
    UserResponseCountDTO getUserFollowersCount(Integer userId)  throws ProgramException;
    UserResponseListDTO getUserFollowersList(Integer userId, String order) throws ProgramException;
    UserResponseListFollowedDTO getUserFollowedList(Integer userId, String order) throws ProgramException;
    void Unfollow (Integer userId, Integer userToUnfollow) throws ProgramException;
}
