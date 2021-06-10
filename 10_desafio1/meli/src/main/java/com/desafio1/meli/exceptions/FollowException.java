package com.desafio1.meli.exceptions;

import org.springframework.http.HttpStatus;

public class FollowException extends MainException {

    public FollowException(Integer userId, Integer userToFollow, String msg) {
        super("User ID:" + userId + " can not " + msg + " User ID:" + userToFollow, HttpStatus.BAD_REQUEST);
    }


}
