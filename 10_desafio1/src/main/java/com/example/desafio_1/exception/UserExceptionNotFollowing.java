package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class UserExceptionNotFollowing extends UserException {
    public UserExceptionNotFollowing(int userId, int userIdToCheck) {
        super("The user with id: ".concat(userId + "").concat(" not follows user with id: ".concat(userIdToCheck + "")), HttpStatus.BAD_REQUEST);
    }
}
