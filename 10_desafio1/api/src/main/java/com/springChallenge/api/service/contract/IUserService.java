package com.springChallenge.api.service.contract;

import com.springChallenge.api.controller.exception.user.UserValidationsException;

public interface IUserService {
    void follow(Integer userId, Integer userIdToFollow) throws UserValidationsException;
}
