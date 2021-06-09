package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.User;

import java.util.ArrayList;

public interface IUserRepository {
    User addFollowUser(int userId, int userIdToFollow) throws UnhandledException;
    User findUserById(int userId) throws UnhandledException;
    ArrayList<User> findFollowersByUserId(int userId) throws UnhandledException;
    ArrayList<User> findFollowedByUserId(int userId) throws UnhandledException;
}
