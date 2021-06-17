package com.example.tucasita.exception;

import org.springframework.http.HttpStatus;

public class PriceException extends TuCasitaException {

    public PriceException() {
        super("District price does not match", HttpStatus.BAD_REQUEST);
    }
}
