package com.springChallenge.api.service.contract;

import com.springChallenge.api.controller.dto.user.FollowedListDTO;
import com.springChallenge.api.controller.dto.user.FollowerCountDTO;
import com.springChallenge.api.controller.dto.user.FollowerListDTO;
import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.controller.exception.user.UserValidationsException;

public interface IUserService {
    void follow(Integer userId, Integer userIdToFollow) throws UserValidationsException;

    FollowerCountDTO getFollowerCount(Integer userId) throws UserNotFoundException;

    FollowerListDTO getFollowerList(Integer userId) throws UserNotFoundException;

    FollowedListDTO getFollowedList(Integer userId) throws UserNotFoundException;
}
