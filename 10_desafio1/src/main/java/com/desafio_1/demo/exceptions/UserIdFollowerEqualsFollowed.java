package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UserIdFollowerEqualsFollowed extends ResponseException {
    public UserIdFollowerEqualsFollowed() {
        super("No puedes seguirte a ti mismo.", HttpStatus.BAD_REQUEST);
    }
}
