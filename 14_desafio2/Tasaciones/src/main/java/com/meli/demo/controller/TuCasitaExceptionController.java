package com.meli.demo.controller;

import com.meli.demo.dto.ErrorDTO;
import com.meli.demo.exepciones.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class TuCasitaExceptionController {


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(TuCasitaException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(HouseNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handleGlobalException(HouseNotFoundException e) {
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(HouseExistException.class)
    protected ResponseEntity<ErrorDTO> handleGlobalException(HouseExistException e) {
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(NeighborhoodNotFounException.class)
    protected ResponseEntity<ErrorDTO> handleGlobalException(NeighborhoodNotFounException e) {
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PriceIncorrectException.class)
    protected ResponseEntity<ErrorDTO> handleGlobalException(PriceIncorrectException e) {
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
