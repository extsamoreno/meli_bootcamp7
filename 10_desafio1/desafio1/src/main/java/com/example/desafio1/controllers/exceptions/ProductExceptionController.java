package com.example.desafio1.controllers.exceptions;

import com.example.desafio1.dtos.ErrorDTO;
import com.example.desafio1.exceptions.product.InvalidDiscountException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(InvalidDiscountException.class)
    public ResponseEntity<ErrorDTO> handlerInvalidDiscountException(InvalidDiscountException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
