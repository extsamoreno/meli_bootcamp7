package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class CategoryDoesntExistException extends ResponseException{
    public CategoryDoesntExistException(int category) {
        super("La categoria con id "+ category +" no existe", HttpStatus.BAD_REQUEST);
    }
}
