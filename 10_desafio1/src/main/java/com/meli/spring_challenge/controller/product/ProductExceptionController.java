package com.meli.spring_challenge.controller.product;

import com.meli.spring_challenge.exception.product.PostAlreadyExistException;
import com.meli.spring_challenge.exception.product.ProductException;
import com.meli.spring_challenge.exception.product.ProductIDAlreadyExistException;
import com.meli.spring_challenge.service.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(ProductException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(ProductException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PostAlreadyExistException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(PostAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductIDAlreadyExistException.class)
    public ResponseEntity<ErrorDto> handleGlobalException(ProductIDAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
