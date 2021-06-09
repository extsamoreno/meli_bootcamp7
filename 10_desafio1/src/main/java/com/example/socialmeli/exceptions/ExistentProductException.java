package com.example.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class ExistentProductException extends ProductException{
    public ExistentProductException(String productId) {
        super("El producto con ID " + productId + " ya existe en el repositorio", HttpStatus.BAD_REQUEST);
    }
}
