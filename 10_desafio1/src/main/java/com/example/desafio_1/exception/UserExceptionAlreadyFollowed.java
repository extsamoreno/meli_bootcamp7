package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class UserExceptionAlreadyFollowed extends UserException{
    public UserExceptionAlreadyFollowed(int userId, int userIdToFollow) {
        super("The user with id: ".concat(userId + "").concat(" already follows user with id: ".concat(userIdToFollow + "")), HttpStatus.BAD_REQUEST);
    }
}
