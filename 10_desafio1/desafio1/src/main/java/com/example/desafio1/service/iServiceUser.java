package com.example.desafio1.service;

import com.example.desafio1.exception.UserAlreadyFollowException;
import com.example.desafio1.exception.UserFollowEqualsFollowerException;
import com.example.desafio1.exception.UserNotFoundException;
import com.example.desafio1.service.dto.ResponseCountFollowersDTO;
import com.example.desafio1.service.dto.ResponseListFollowedDTO;
import com.example.desafio1.service.dto.ResponseListFollowersDTO;
import com.example.desafio1.service.dto.ResponseUserDTO;

public interface iServiceUser {

    void followUser(Integer userId, Integer userIdToFollow) throws UserNotFoundException, UserAlreadyFollowException, UserFollowEqualsFollowerException;
    ResponseCountFollowersDTO countFollowers(Integer userId) throws UserNotFoundException;
    ResponseListFollowersDTO listFollowers(Integer userId) throws  UserNotFoundException;
    ResponseListFollowedDTO listFollowed(Integer userId) throws UserNotFoundException;
}
