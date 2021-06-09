package com.desafio_1.demo.exceptions;

import org.springframework.http.HttpStatus;

public class ProductDetailBrandRequiredException extends ResponseException{
    public ProductDetailBrandRequiredException() {
        super("La marca es requerida.", HttpStatus.BAD_REQUEST);
    }
}
