package com.example.MeliSocialApi.project.exception;

import org.springframework.http.HttpStatus;

public class ProductNoValidDateException extends ProductException {
    public ProductNoValidDateException() {
        super("The date is not valid", HttpStatus.BAD_REQUEST);
    }
}
