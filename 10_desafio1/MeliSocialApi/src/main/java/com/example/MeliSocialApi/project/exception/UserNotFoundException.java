package com.example.MeliSocialApi.project.exception;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {
    public UserNotFoundException(Integer id) {
        super("ID: "+id+" not found", HttpStatus.BAD_REQUEST);
    }
}
