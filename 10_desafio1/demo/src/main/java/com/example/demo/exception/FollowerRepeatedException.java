package com.example.demo.exception;

import org.springframework.http.HttpStatus;

public class FollowerRepeatedException extends GenericException{
    public FollowerRepeatedException(Integer userId, Integer userIdToFollow) {
        super("El usuario con id " + userId + " ya es seguidor del usuario " + userIdToFollow , HttpStatus.BAD_REQUEST);
    }
}
