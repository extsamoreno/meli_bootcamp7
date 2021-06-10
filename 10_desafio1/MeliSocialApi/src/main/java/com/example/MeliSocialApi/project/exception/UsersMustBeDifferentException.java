package com.example.MeliSocialApi.project.exception;

import org.springframework.http.HttpStatus;

public class UsersMustBeDifferentException extends UserException {
    public UsersMustBeDifferentException() {
        super("Users cannot be the same", HttpStatus.BAD_REQUEST);
    }
}