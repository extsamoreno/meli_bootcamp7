package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.ErrorDTO;
import com.desafio_1.demo.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(ProductDateInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDetailRequiredException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductDetailRequiredException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductCategoryInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductCategoryInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductPriceInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductPriceInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductIdPostInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductIdPostInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
