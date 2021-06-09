package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidFollowerException extends UserException{
    public InvalidFollowerException() {
        super("No se puede realizar el seguimiento de dos usuarios con el mismo ID", HttpStatus.BAD_REQUEST);
    }
}
