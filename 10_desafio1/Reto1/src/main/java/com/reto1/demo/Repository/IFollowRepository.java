package com.reto1.demo.Repository;

import com.reto1.demo.Exception.UserAlreadyFollowException;
import com.reto1.demo.Exception.UserIdNotFoundException;
import com.reto1.demo.Model.User;

public interface IFollowRepository {

    String follow(int userId, int userIdToFollow) throws UserIdNotFoundException, UserAlreadyFollowException;
    User getUserById(int userId) throws UserIdNotFoundException;}