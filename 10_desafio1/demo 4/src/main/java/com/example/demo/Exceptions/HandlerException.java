package com.example.demo.exceptions;


import com.example.demo.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandlerException {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorDTO> badRequestException(BadRequestException ex){
        return ResponseEntity.status(ex.getStatus()).body(new ErrorDTO(ex.getErrorMessage()));
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorDTO> notFoundException(NotFoundException ex){
        return ResponseEntity.status(ex.getStatus()).body(new ErrorDTO(ex.getErrorMessage()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> internalException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ErrorDTO(ex.getMessage()));
    }
}
