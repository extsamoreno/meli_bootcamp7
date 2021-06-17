package com.meli.desafio2.web.controller;

import com.meli.desafio2.web.dto.ErrorDTO;
import com.meli.desafio2.web.exception.DistrictAlreadyExistException;
import com.meli.desafio2.web.exception.DistrictNotFoundException;
import com.meli.desafio2.web.exception.PropertyAlreadyExistException;
import com.meli.desafio2.web.exception.PropertyNameNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class DesafioExceptionController {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult().getAllErrors().forEach((error) -> {
                String fieldName = ((FieldError) error).getField();
                String errorMessage = error.getDefaultMessage();
                errors.put(fieldName,errorMessage);
            });
            System.out.println("ingreso a excepción");
            ErrorDTO errorDTO = new ErrorDTO(MethodArgumentNotValidException.class.getSimpleName(),errors);
            return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
        }

    @ExceptionHandler(PropertyNameNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PropertyNameNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(PropertyAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PropertyAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DistrictAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DistrictAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DistrictNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }


}
