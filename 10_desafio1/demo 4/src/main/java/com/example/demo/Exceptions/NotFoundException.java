package com.example.demo.Exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CustomException{

    public NotFoundException(String errorMessage) {
        this.setStatus(HttpStatus.NOT_FOUND);
        this.setErrorMessage(errorMessage);
    }
}
