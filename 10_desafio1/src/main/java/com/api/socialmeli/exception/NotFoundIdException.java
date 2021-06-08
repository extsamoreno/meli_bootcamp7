package com.api.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class NotFoundIdException extends SocialMeliException {
    public NotFoundIdException(Integer id) {
        super("ID Not Found", HttpStatus.BAD_REQUEST);
    }
}

