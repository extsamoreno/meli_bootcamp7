package com.example.desafio_1.service;

import com.example.desafio_1.exception.UserExceptionAlreadyFollowed;
import com.example.desafio_1.exception.UserExceptionNotFound;
import com.example.desafio_1.exception.UserExceptionWrongType;
import com.example.desafio_1.service.dto.UserDTO;

public interface IUserService {
    void followUser(int userId, int userIdToFollow) throws UserExceptionNotFound, UserExceptionWrongType, UserExceptionAlreadyFollowed;

    UserDTO getFollowersCount(int userId) throws UserExceptionNotFound, UserExceptionWrongType;

    UserDTO getFollowersList(int userId) throws UserExceptionWrongType, UserExceptionNotFound;

    UserDTO getFollowingList(int userId) throws UserExceptionWrongType, UserExceptionNotFound;
}
