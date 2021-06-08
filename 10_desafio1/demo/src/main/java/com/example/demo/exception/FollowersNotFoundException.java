package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class FollowersNotFoundException extends GenericException{
    public FollowersNotFoundException(Integer userId) {
        super("El usuario " + userId+" no tiene ningun seguidor ", HttpStatus.BAD_REQUEST);
    }
}
