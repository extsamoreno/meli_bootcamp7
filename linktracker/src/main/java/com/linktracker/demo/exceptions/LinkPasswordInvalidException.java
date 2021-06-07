package com.linktracker.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkPasswordInvalidException extends ResponseException {
    public LinkPasswordInvalidException() {
        super("La contraseña es insegura, debe ingresar al menos un numero, una letra y un caracter especial.", HttpStatus.NOT_FOUND);
    }
}
