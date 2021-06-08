package com.desafiospring.socialMeli.controller;

import com.desafiospring.socialMeli.dto.ErrorDTO;
import com.desafiospring.socialMeli.exceptions.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<ErrorDTO> returnError(UserException e){
        return new ResponseEntity<>(e.getErrorDTO(),e.getHttpStatus());
    }

    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> returnError(Exception e){
        return new ResponseEntity<>("Internal Server Error", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
