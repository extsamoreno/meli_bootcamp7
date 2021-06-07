package com.example.springboot.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPasswordException extends LinkException {
    public InvalidPasswordException(Integer id) {
        super("La contraseña ingresada para la URL de id= " + id + " no es válida.", HttpStatus.BAD_REQUEST);
    }
}
