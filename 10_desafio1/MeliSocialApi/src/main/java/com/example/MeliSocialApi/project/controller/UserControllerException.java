package com.example.MeliSocialApi.project.controller;

import com.example.MeliSocialApi.project.exception.UserException;
import com.example.MeliSocialApi.project.service.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserException e){
        return new ResponseEntity<ErrorDTO>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorDTO> handleDateExceptions(HttpMessageNotReadableException ex) {
        return new ResponseEntity<>(new ErrorDTO(ex.getMessage().split(" \\(")[0], ex.getClass().getSimpleName()), HttpStatus.BAD_REQUEST);
    }
}