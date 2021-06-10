package com.example.desafio1.exception.user;

import org.springframework.http.HttpStatus;

public class UserNotFollowException extends UserException {

    public UserNotFollowException(Integer userId, Integer userIdToUnfollow) {
        super("User id " + userId + " doesn't follow user id " + userIdToUnfollow, HttpStatus.BAD_REQUEST);
    }
}
