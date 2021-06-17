package com.meli.calculatorHouseSquareMeters.integration.controller;

import com.meli.calculatorHouseSquareMeters.model.dto.ErrorDTO;
import com.meli.calculatorHouseSquareMeters.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class CalculatorHouseExceptionController {
    @ExceptionHandler(CalculatorHouseException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException (CalculatorHouseException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictNotCreatedException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNotCreatedException (DistrictNotCreatedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNotFoundException (DistrictNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(HouseNotCreatedException.class)
    public ResponseEntity<ErrorDTO> handleHouseNotCreatedException (HouseNotCreatedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleHouseNotFoundException (HouseNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(RepeatedDistrictException.class)
    public ResponseEntity<ErrorDTO> handleRepeatedDistrictException (RepeatedDistrictException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(RepeatedHouseException.class)
    public ResponseEntity<ErrorDTO> handleRepeatedHouseException (RepeatedHouseException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
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
