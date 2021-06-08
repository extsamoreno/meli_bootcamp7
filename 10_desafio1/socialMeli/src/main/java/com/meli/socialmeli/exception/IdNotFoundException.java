package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class IdNotFoundException extends SocialMeliException {

    public IdNotFoundException(Integer userId) {
        super("User ID: " + userId + " invalid or does not exist", HttpStatus.NOT_FOUND);
    }
}
