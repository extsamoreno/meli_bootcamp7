package com.desafio.socialMeli.model.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends UserException {
    public UserNotFoundException() {
        super("El usuario no pudo ser encontrado ", HttpStatus.BAD_REQUEST);
    }
}
