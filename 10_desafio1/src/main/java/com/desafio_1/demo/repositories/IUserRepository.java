package com.desafio_1.demo.repositories;

import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.models.User;

import java.util.ArrayList;
import java.util.Comparator;

public interface IUserRepository {
    void addFollowUser(int userId, int userIdToFollow) throws UnhandledException;
    User findUserById(int userId) throws UnhandledException;
    ArrayList<User> findFollowersByUserId(int userId, Comparator<String> comparator) throws UnhandledException;
    ArrayList<User> findFollowedByUserId(int userId, Comparator<String> comparator) throws UnhandledException;
    void unfollowUser(int userId, int userIdToUnfollow) throws UnhandledException;;
}
