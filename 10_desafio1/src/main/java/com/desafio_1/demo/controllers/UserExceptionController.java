package com.desafio_1.demo.controllers;

import com.desafio_1.demo.dtos.ErrorDTO;
import com.desafio_1.demo.exceptions.UnhandledException;
import com.desafio_1.demo.exceptions.UserIdFollowerEqualsFollowed;
import com.desafio_1.demo.exceptions.UserIdInvalidException;
import com.desafio_1.demo.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserIdInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdInvalidException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UnhandledException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UnhandledException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFoundException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserIdFollowerEqualsFollowed.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdFollowerEqualsFollowed e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
