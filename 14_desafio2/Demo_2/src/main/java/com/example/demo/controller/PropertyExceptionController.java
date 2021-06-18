package com.example.demo.controller;

import com.example.demo.DTO.ErrorDTO;
import com.example.demo.exception.DistrictNotFoundException;
import com.example.demo.exception.PropertyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PropertyExceptionController {

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> districtNotFoundException(DistrictNotFoundException e){
            return new ResponseEntity<>(e.getError(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorDTO> propertyNotFoundException(PropertyNotFoundException e){
        return new ResponseEntity<>(e.getError(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(MethodArgumentNotValidException e) {
        ErrorDTO error = new ErrorDTO(e.getBindingResult().getFieldError().getDefaultMessage(),"MethodArgumentNotValidException");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    protected ResponseEntity<ErrorDTO> handleValidationExceptions(HttpMessageNotReadableException e) {
        ErrorDTO error = new ErrorDTO(e.getMessage(),"HttpMessageNotReadableException");
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
