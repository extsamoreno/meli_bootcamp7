package com.spring.desafioSpring.Repositories;

import com.spring.desafioSpring.Exceptions.AlreadyFollowException;
import com.spring.desafioSpring.Exceptions.UserNotFoundException;
import com.spring.desafioSpring.Models.User;

public interface IUserRepository {
    void follow(int userId, Integer userIdToFollow) throws UserNotFoundException, AlreadyFollowException;
    void unfollow(int userId, int userIdToUnollow) throws UserNotFoundException;
    User getUser(int userId) throws UserNotFoundException;
    int countFollowersByUser(int userId) throws UserNotFoundException;

}
