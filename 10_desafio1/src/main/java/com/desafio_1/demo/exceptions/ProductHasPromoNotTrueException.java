package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductHasPromoNotTrueException extends ResponseException{
    public ProductHasPromoNotTrueException() {
        super("Para añadir un producto en promocion con descuento, hasPromo debe ser true.", HttpStatus.BAD_REQUEST);
    }
}
