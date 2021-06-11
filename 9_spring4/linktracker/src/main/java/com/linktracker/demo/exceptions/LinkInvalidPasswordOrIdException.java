package com.linktracker.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkInvalidPasswordOrIdException extends ResponseException{
    public LinkInvalidPasswordOrIdException() {
        super("La url con el id y la contraseña ingresados no existe.", HttpStatus.NOT_FOUND);
    }
}
