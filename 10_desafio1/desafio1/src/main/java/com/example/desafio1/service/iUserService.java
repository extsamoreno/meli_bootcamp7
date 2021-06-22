package com.example.desafio1.service;

import com.example.desafio1.exception.user.UserAlreadyFollowException;
import com.example.desafio1.exception.user.UserFollowEqualsFollowerException;
import com.example.desafio1.exception.user.UserNotFollowException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.service.dto.user.ResponseCountFollowersDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowedDTO;
import com.example.desafio1.service.dto.user.ResponseListFollowersDTO;

public interface iUserService {

    void followUser(Integer userId, Integer userIdToFollow) throws UserNotFoundException, UserAlreadyFollowException, UserFollowEqualsFollowerException;

    ResponseCountFollowersDTO countFollowers(Integer userId) throws UserNotFoundException;

    ResponseListFollowersDTO listFollowers(Integer userId, String order) throws UserNotFoundException;

    ResponseListFollowedDTO listFollowed(Integer userId, String order) throws UserNotFoundException;

    void unFollowUser(Integer userId, Integer userIdToUnFollow) throws UserNotFoundException, UserNotFollowException;
}