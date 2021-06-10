package com.example.desafio_1.service;

import com.example.desafio_1.exception.*;
import com.example.desafio_1.models.User;
import com.example.desafio_1.service.dto.FollowedListDTO;
import com.example.desafio_1.service.dto.FollowerCountDTO;
import com.example.desafio_1.service.dto.FollowerListDTO;
import com.example.desafio_1.service.dto.UserDTO;

public interface IUserService {
    void followUser(int userId, int userIdToFollow) throws UserExceptionNotFound, UserExceptionWrongType, UserExceptionAlreadyFollowed;

    FollowerCountDTO getFollowersCount(int userId) throws UserExceptionNotFound, UserExceptionWrongType;

    FollowerListDTO getFollowersList(int userId, String order) throws UserExceptionWrongType, UserExceptionNotFound, WrongOrderFieldException;

    FollowedListDTO getFollowingList(int userId, String order) throws UserExceptionWrongType, UserExceptionNotFound, WrongOrderFieldException;

    boolean existsUser(int userId) throws UserExceptionNotFound;

    void checkInstance(User user, String instanceType) throws UserExceptionWrongType;

    void checkInstance(int userId, String instanceType) throws UserExceptionWrongType, UserExceptionNotFound;

    User getUserById(int userId) throws UserExceptionNotFound;

    void unfollowUser(int userId, int userIdToUnFollow) throws UserExceptionNotFound, UserExceptionWrongType, UserExceptionNotFollowing;
}
