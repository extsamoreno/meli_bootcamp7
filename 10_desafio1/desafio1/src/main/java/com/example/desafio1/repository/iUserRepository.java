package com.example.desafio1.repository;

import com.example.desafio1.exception.user.UserNotFollowException;
import com.example.desafio1.exception.user.UserNotFoundException;
import com.example.desafio1.model.User;

public interface iUserRepository {

    User saveUser(User user);
    User findUserById(Integer id) throws UserNotFoundException;
    void unFollowUser(Integer userId, Integer userIdToUnFollow) throws UserNotFoundException, UserNotFollowException;
    void loadUsers();
}
