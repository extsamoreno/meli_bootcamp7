package com.socialmeli.desafio.Exception;

import org.springframework.http.HttpStatus;

public class RegisteredFollowerException extends UserException{


    public RegisteredFollowerException(int id) {
        super("El usuario id: "+id+" ya sigue al vendedor", HttpStatus.BAD_REQUEST);
    }
}
