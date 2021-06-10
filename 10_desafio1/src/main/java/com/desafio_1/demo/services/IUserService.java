package com.desafio_1.demo.services;

import com.desafio_1.demo.dtos.UserFollowedDTO;
import com.desafio_1.demo.dtos.UserFollowerCountDTO;
import com.desafio_1.demo.dtos.UserFollowerDTO;
import com.desafio_1.demo.exceptions.*;

public interface IUserService {
    void addFollowUser(int userId, int userIdToFollow) throws UnhandledException, BadRequestException;

    UserFollowerCountDTO findFollowersCount(int userId) throws UnhandledException, BadRequestException;

    UserFollowerDTO findFollowersByUserId(int userId, String order) throws UnhandledException, BadRequestException;

    UserFollowedDTO findFollowedByUserId(int userId, String order) throws UnhandledException, BadRequestException;

    void unfollowUser(int userId, int userIdToUnfollow) throws UnhandledException, BadRequestException;
}
