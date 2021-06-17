package com.example.tucasita.exception;

import org.springframework.http.HttpStatus;

public class PriceNotMatchException extends TuCasitaException {

    public PriceNotMatchException() {
        super("District price does not match", HttpStatus.BAD_REQUEST);
    }
}
