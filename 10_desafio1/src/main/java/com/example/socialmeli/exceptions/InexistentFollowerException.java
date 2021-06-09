package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InexistentFollowerException extends UserException{
    public InexistentFollowerException(int userId, int userIdToUnfollow) {
        super("El usuario con ID " + userId + " no sigue al usuario con ID " + userIdToUnfollow, HttpStatus.BAD_REQUEST);
    }
}
