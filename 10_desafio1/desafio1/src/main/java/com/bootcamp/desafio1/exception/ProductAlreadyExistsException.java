package com.bootcamp.desafio1.exception;

import org.springframework.http.HttpStatus;

public class ProductAlreadyExistsException extends GeneralException{
    public ProductAlreadyExistsException(int productId) {
        super("The Product with ID: " +productId+ " already exists in the DataBase.", HttpStatus.BAD_REQUEST);
    }
}
