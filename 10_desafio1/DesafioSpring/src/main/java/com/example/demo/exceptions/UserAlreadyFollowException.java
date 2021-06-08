package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyFollowException extends ResponseException{
    public UserAlreadyFollowException(int userId, int userIdToFollow) {
        super("El usuario con id "+ userId +" ya sigue al usuario con id "+ userIdToFollow, HttpStatus.BAD_REQUEST);
    }
}