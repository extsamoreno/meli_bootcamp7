package com.meli.desafio.controllers;

import com.meli.desafio.exceptions.ExceptionModel;
import com.meli.desafio.exceptions.dto.ErrorDTO;
import com.meli.desafio.exceptions.models.DistrictNotFoundException;
import com.meli.desafio.exceptions.models.HouseAlreadyExistsException;
import com.meli.desafio.exceptions.models.HouseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CalculateExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleValidationException(MethodArgumentNotValidException e){
        ErrorDTO error = ErrorDTO.builder()
                .name("MethodArgumentNotValidException")
                .message(e.getBindingResult().getFieldError().getDefaultMessage())
                .build();

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(HouseAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleHouseAlreadyExistException(HouseAlreadyExistsException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(HouseNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleHouseNotFoundException(HouseNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(DistrictNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDistrictNotFoundException(DistrictNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
