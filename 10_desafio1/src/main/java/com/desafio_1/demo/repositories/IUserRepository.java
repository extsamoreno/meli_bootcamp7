package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.User;

public interface IUserRepository {
    User addFollowUser(Integer userId, Integer userIdToFollow) throws UnhandledException;
    User findUserById(Integer userId) throws UnhandledException;
}
