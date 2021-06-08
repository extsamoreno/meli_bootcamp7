package com.meli.socialmeli.exception;

import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends ApiException {
    public UserIdNotFoundException(Integer userId) {
        super("The id " + userId + " does not belong to a registered user", HttpStatus.BAD_REQUEST);
    }
}
