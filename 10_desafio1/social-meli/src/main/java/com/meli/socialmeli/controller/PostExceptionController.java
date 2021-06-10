package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.ApiError;
import com.meli.socialmeli.exception.PostAlreadyInsertedException;
import com.meli.socialmeli.exception.UserIdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ApiError> handleUserIdNotFoundException(UserIdNotFoundException ex) {
        return new ResponseEntity<>(ex.getError(),ex.getStatus());
    }

    @ExceptionHandler(PostAlreadyInsertedException.class)
    public ResponseEntity<ApiError> handlePostAlreadyInsertedException(PostAlreadyInsertedException ex) {
        return new ResponseEntity<>(ex.getError(),ex.getStatus());
    }
}
