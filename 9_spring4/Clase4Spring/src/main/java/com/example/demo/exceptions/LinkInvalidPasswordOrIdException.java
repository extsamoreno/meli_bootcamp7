package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;

public class LinkInvalidPasswordOrIdException extends ResponseException{
    public LinkInvalidPasswordOrIdException() {
        super("La direccion con el id y la contraseña ingresados no existe.", HttpStatus.NOT_FOUND);
    }
}
