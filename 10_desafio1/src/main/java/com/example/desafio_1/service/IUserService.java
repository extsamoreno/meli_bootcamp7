package com.example.desafio_1.service;

import com.example.desafio_1.exception.UserExceptionNotFound;
import com.example.desafio_1.exception.UserExceptionWrongType;

public interface IUserService {
    void followUser(int userId, int userIdToFollow) throws UserExceptionNotFound, UserExceptionWrongType;
}
