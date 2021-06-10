package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class InvalidSortTypeException extends SocialMeliException {

    public InvalidSortTypeException(String order) {
        super("Order type: " + order + " is not valid", HttpStatus.BAD_REQUEST);
    }
}
