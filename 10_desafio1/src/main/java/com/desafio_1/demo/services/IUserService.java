package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.UserFollowDTO;
import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.exceptions.UserIdFollowerEqualsFollowed;
import com.desafio_1.demo.exceptions.UserIdInvalidException;
import com.desafio_1.demo.exceptions.UserNotFoundException;

public interface IUserService {
    UserFollowDTO addFollowUser(Integer userId, Integer userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed;

    UserFollowerCountDTO findFollowersCount(Integer userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException;

    UserFollowerDTO findFollowersByUserId(Integer userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException;
}
