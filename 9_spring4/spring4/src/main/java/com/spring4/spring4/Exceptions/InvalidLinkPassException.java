package com.spring4.spring4.Exceptions;

import org.springframework.http.HttpStatus;

public class InvalidLinkPassException extends ObjectException{
    public InvalidLinkPassException(Integer id) {
        super("Contraseña incorrecta para el link: " + id, HttpStatus.CONFLICT);
    }
}
