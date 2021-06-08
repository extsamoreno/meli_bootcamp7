package com.example.demo.Exeptions;

import org.springframework.http.HttpStatus;

public class BadRequestExeption extends CustomExeption {

    public BadRequestExeption(String errorMessage) {
        this.setStatus(HttpStatus.BAD_REQUEST);
        this.setErrorMessage(errorMessage);
    }
}
