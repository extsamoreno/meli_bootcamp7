package com.example.desafio_1.exception;

import org.springframework.http.HttpStatus;

public class ProductExceptionNotFound extends ProductException{
    public ProductExceptionNotFound(int productId) {
        super("The product with id: ".concat(productId + "").concat(" don't exists"), HttpStatus.BAD_REQUEST);
    }
}
