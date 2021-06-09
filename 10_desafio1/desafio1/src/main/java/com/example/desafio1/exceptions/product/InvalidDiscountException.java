package com.example.desafio1.exceptions.product;

import org.springframework.http.HttpStatus;

public class InvalidDiscountException extends ProductException {
    public InvalidDiscountException(double discount) {
        super("El descuento ingresado: "
                + discount + " debe ser mayor o igual a 0 y menor o igual a 1, siendo 0 = 0% y 1 = 100%",
                HttpStatus.BAD_REQUEST);
    }
}
