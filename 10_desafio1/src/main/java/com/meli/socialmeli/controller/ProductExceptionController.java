package com.meli.socialmeli.controller;

import com.meli.socialmeli.dto.ErrorDTO;
import com.meli.socialmeli.exception.PostIdAlreadyExistsException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductExceptionController {

    @ExceptionHandler(PostIdAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handlePostIdAlreadyExistsException(PostIdAlreadyExistsException e) {
        return new ResponseEntity<>(e.getErrorDTO(), e.getHttpStatus());
    }
}
