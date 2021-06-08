package com.socialmedia.socialmedia.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends SocialMediaException {
    public UserNotFoundException(int userId) {
        super("El usuario " + userId +" no existe.", HttpStatus.BAD_REQUEST);
    }
}


