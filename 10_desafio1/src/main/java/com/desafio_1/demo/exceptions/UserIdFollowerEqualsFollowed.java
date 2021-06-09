package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class UserIdFollowerEqualsFollowed extends ResponseException {
    public UserIdFollowerEqualsFollowed() {
        super("El id de seguidor no puede ser el mismo de seguido.", HttpStatus.BAD_REQUEST);
    }
}
