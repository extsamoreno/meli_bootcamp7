package com.meli.socialmeli.controller;

import com.meli.socialmeli.exception.SocialException;
import com.meli.socialmeli.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(SocialException exception) {
        return new ResponseEntity<ErrorDTO>(exception.getError(), exception.getStatus());
    }

}
