package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class ExistentFollowerException extends UserException{
    public ExistentFollowerException(int userId, int userIdToFollow) {
        super("El usuario con ID " + userId + " ya sigue al usuario con ID " + userIdToFollow, HttpStatus.BAD_REQUEST);
    }
}
