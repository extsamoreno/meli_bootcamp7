package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class CanNotFollowException extends SocialMeliException {

    public CanNotFollowException(Integer userId, Integer userToFollow) {
        super("User ID:" + userId + " already following User ID:" + userToFollow, HttpStatus.BAD_REQUEST);
    }
}
