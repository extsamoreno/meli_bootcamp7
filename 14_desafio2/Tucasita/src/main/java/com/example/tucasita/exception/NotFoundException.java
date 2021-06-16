package com.example.tucasita.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends TuCasitaException {

    public NotFoundException() {
        super("Invalid data or does not exist", HttpStatus.BAD_REQUEST);
    }
}
