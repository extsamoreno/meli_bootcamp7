package com.meli.socialmeli.controller.post;

import com.meli.socialmeli.exception.*;
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

    @ExceptionHandler(ProductAlreadyPostedException.class)
    public ResponseEntity<ApiError> handleProductAlreadyPostedException(ProductAlreadyPostedException ex) {
        return new ResponseEntity<>(ex.getError(),ex.getStatus());
    }

    @ExceptionHandler(InvalidDateException.class)
    public ResponseEntity<ApiError> handleInvalidDateException(InvalidDateException ex) {
        return new ResponseEntity<>(ex.getError(),ex.getStatus());
    }
}
