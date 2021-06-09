package com.example.challenge.Exceptions;

import org.springframework.http.HttpStatus;

public class UserSameIdException extends ApiException {
    public UserSameIdException() {
        super("The same user can not be use in both arguments", HttpStatus.BAD_REQUEST);
    }
}
