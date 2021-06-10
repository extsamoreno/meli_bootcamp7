package com.meli.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class UserDoNotExistsException extends UserException {
        public UserDoNotExistsException() {
            super("El usuario no existe en la base de datos.", HttpStatus.BAD_REQUEST);
    }
}
