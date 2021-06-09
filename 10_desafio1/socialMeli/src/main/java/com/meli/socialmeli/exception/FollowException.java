package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class FollowException extends SocialMeliException {

    public FollowException(Integer userId, Integer userToFollow, String msg) {
        super("User ID:" + userId + " can not " + msg + " User ID:" + userToFollow, HttpStatus.BAD_REQUEST);
    }


}
