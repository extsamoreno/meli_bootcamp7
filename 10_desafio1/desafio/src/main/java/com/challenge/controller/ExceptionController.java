package com.challenge.controller;

import com.challenge.dto.ErrorResponse;
import com.challenge.exception.PostIdAlreadyExistsException;
import com.challenge.exception.UserIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUserIdNotFoundException(UserIdNotFoundException e) {
        return new ResponseEntity<>(e.getError(), e.getHttpStatus());
    }

    @ExceptionHandler(PostIdAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handlePostIdAlreadyExistsException(PostIdAlreadyExistsException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(IOException.class)
    public ResponseEntity handleIOException(IOException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
