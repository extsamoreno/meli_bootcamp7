package com.example.ChallengeTwo.controller;

import com.example.ChallengeTwo.dto.ErrorDTO;
import com.example.ChallengeTwo.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HouseControllerException {

    @ExceptionHandler(DistrictAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DistrictAlreadyExistsException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(HouseAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(HouseAlreadyExistsException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(DistrictNameNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DistrictNameNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(HouseNameNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(HouseNameNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProgramException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

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
}
