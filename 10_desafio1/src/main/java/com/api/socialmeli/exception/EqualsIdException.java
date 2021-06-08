package com.api.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class EqualsIdException extends SocialMeliException {
    public EqualsIdException() {
        super("Equals IDs", HttpStatus.BAD_REQUEST);
    }
}

