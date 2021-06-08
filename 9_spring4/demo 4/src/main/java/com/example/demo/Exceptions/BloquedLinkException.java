package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class BloquedLinkException extends UrlException{

    public BloquedLinkException() {
        super("El sitio se encuentra deshabilitado.", HttpStatus.BAD_REQUEST);
    }
}
