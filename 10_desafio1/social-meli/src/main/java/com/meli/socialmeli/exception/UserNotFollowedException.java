package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class UserNotFollowedException extends ApiException{
    public UserNotFollowedException(Integer userId, Integer userIdToUnfollow) {
        super("The user " + userId + " does not follow user " + userIdToUnfollow, HttpStatus.BAD_REQUEST);
    }
}
