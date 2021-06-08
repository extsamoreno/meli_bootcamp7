package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class UserExceptionWrongType extends UserException{
    public UserExceptionWrongType(int userId, String type) {
        super("The user with id: ".concat(userId + "").concat(" must be of the type: ").concat(type), HttpStatus.BAD_REQUEST);
    }
}
