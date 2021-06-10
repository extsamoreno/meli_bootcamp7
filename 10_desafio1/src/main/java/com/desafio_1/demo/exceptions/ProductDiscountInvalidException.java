package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDiscountInvalidException extends ResponseException {
    public ProductDiscountInvalidException() {
        super("Para añadir un producto en promocion, el descuento del producto debe ser mayor a 0.", HttpStatus.BAD_REQUEST);
    }
}
