package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.UserFollowedDTO;
import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.exceptions.UserIdFollowerEqualsFollowed;
import com.desafio_1.demo.exceptions.UserIdInvalidException;
import com.desafio_1.demo.exceptions.UserNotFoundException;

public interface IUserService {
    UserFollowedDTO addFollowUser(int userId, int userIdToFollow) throws UserIdInvalidException, UnhandledException, UserIdFollowerEqualsFollowed, UserNotFoundException;

    UserFollowerCountDTO findFollowersCount(int userId) throws UserIdInvalidException, UnhandledException, UserNotFoundException;

    UserFollowerDTO findFollowersByUserId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException;

    UserFollowedDTO findFollowedByUserId(int userId, String order) throws UserIdInvalidException, UnhandledException, UserNotFoundException;

    UserFollowedDTO unfollowUser(int userId, int userIdToUnfollow) throws UserIdFollowerEqualsFollowed, UserIdInvalidException, UserNotFoundException, UnhandledException;
}
