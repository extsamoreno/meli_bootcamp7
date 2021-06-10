package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowedException extends ApiException{
    public UserAlreadyFollowedException(Integer userId, Integer userIdToFollow) {
        super("The user " + userId + " already follows user " + userIdToFollow, HttpStatus.BAD_REQUEST);
    }
}
