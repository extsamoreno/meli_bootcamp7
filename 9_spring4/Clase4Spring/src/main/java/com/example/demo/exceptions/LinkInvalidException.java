package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkInvalidException extends ResponseException {

    public LinkInvalidException(String address) {
        super("La direccion "+ address +" es invalida.", HttpStatus.NOT_FOUND);
    }
}
