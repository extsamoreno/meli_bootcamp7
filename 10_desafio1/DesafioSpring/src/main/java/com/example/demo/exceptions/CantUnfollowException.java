package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class CantUnfollowException extends ResponseException{
    public CantUnfollowException(int userId,int userToUnfollowId) {
        super("El usuario con id "+userId+" no puede dejar de seguir a al usuario con id "+userToUnfollowId, HttpStatus.BAD_REQUEST);
    }
}
