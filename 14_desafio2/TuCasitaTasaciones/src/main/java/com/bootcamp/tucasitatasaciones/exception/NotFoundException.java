package com.bootcamp.tucasitatasaciones.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class NotFoundException extends PropertyException {

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
