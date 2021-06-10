package com.example.MeliSocialApi.project.controller;

import com.example.MeliSocialApi.project.exception.ProductException;
import com.example.MeliSocialApi.project.exception.UserException;
import com.example.MeliSocialApi.project.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductControllerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductException e) {
        return new ResponseEntity<ErrorDTO>(e.getError(), e.getStatus());
    }
}
