package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.ApiError;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ApiError> handleUserIdNotFoundException(UserIdNotFoundException ex) {
        return new ResponseEntity<>(ex.getError(),ex.getStatus());
    }
}
