package com.springChallenge.api.repository.contract;

import com.springChallenge.api.controller.exception.user.UserNotFoundException;
import com.springChallenge.api.repository.entity.User;

public interface IUserRepository {
    User getByUserId(int userId) throws UserNotFoundException;

    void save(User user);
}
