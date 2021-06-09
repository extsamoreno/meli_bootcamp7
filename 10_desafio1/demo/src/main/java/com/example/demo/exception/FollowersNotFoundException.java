package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class FollowersNotFoundException extends GenericException{
    public FollowersNotFoundException(Integer userId, Integer userFollower) {
        super("El usuario " + userId+" no esta siguiendo a " + userFollower, HttpStatus.BAD_REQUEST);
    }
}
