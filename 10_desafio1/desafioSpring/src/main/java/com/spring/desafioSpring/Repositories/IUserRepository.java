package com.spring.desafioSpring.Repositories;

import com.spring.desafioSpring.Exceptions.UserNotFoundException;
import com.spring.desafioSpring.Models.User;

public interface IUserRepository {
    void follow(int userId, int userIdToFollow) throws UserNotFoundException;
    User getUser(int userId) throws UserNotFoundException;
}
