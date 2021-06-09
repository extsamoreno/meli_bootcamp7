package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends CustomException {

    public BadRequestException(String errorMessage) {
        this.setStatus(HttpStatus.BAD_REQUEST);
        this.setErrorMessage(errorMessage);
    }
}
