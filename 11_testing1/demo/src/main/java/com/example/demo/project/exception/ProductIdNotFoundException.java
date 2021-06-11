package com.example.demo.project.exception;

import org.springframework.http.HttpStatus;

public class ProductIdNotFoundException extends ProductException {
    public ProductIdNotFoundException(Integer idProduct) {
        super("El id: "+idProduct+" no corresponde a ningun Product", HttpStatus.BAD_REQUEST);
    }
}
