package com.socialmedia.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

public class UserDistinctTypeException extends SocialMediaException {

    public UserDistinctTypeException(int userId, String type) {
        super("El usuario " + userId + " no es del tipo " + type, HttpStatus.BAD_REQUEST);
    }
}
