package com.example.demo.controllers;

import com.example.demo.dtos.ErrorDTO;
import com.example.demo.exceptions.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserAlreadyFollowException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserAlreadyFollowException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserDontFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserDontFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(ProductDontFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ProductDontFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(CategoryDoesntExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(CategoryDoesntExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(InvalidDateFormatException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidDateFormatException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(CantAutofollowException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(CantAutofollowException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(CantUnfollowException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(CantUnfollowException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}