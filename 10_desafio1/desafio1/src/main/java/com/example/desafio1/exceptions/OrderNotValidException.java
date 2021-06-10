package com.example.desafio1.exceptions;

import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class OrderNotValidException extends ResponseException {
    public OrderNotValidException(String order) {
        super("The order '" + order + "' requested is NOT valid", HttpStatus.BAD_REQUEST);
    }
}
