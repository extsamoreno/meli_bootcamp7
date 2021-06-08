package com.spring.desafioSpring.Exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends ObjectException{
    public UserNotFoundException(int idUser) {
        super("Usuario: " + idUser + " no encontrado", HttpStatus.BAD_REQUEST);
    }
}
