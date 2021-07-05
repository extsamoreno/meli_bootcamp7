package com.muelitas.demo.controllers;

import com.muelitas.demo.dtos.ErrorDTO;
import com.muelitas.demo.exceptions.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(MethodArgumentNotValidException e){
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setName(e.getClass().getSimpleName());
        errorDTO.setMessage(new String());
        e.getBindingResult().getAllErrors().forEach((error) ->{
            errorDTO.setMessage(errorDTO.getMessage().concat(((FieldError)error).getField() + "=" + error.getDefaultMessage()));
        });
        return new ResponseEntity<>(errorDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(BadRequestException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
