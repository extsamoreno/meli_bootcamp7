package com.bootcamp.desafio2.controller;

import com.bootcamp.desafio2.dto.response.ErrorDTO;
import com.bootcamp.desafio2.exception.district.DistrictNotFoundException;
import com.bootcamp.desafio2.exception.house.HouseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleHouseNotFoundException(HouseNotFoundException e) {
        return new ResponseEntity(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNotFoundException(DistrictNotFoundException e) {
        return new ResponseEntity(e.getError(), e.getStatus());
    }


    // Validations Handler
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO("MethodArgumentNotValidException", e.getBindingResult().getFieldError().getDefaultMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO("HttpMessageNotReadableException", e.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
