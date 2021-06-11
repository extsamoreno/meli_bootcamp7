package com.example.diploma.controller;

import com.example.diploma.dto.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ObtenerDiplomaExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
        return new ResponseEntity<>(
                new ErrorDTO(e.getBindingResult().getAllErrors(), e.getClass().getSimpleName()),
                HttpStatus.OK);
    }
}