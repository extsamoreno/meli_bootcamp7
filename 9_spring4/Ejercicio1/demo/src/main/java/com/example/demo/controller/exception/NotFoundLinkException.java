package com.example.demo.controller.exception;

import org.springframework.http.HttpStatus;

public class NotFoundLinkException extends GenericException {
    public NotFoundLinkException(String key) {
        super("No existe un link registrado con el id " + key, HttpStatus.NOT_FOUND);
    }
}
