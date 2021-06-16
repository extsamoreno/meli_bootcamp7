package com.meli.desafio1.web.controller;

import com.meli.desafio1.web.dto.ErrorDTO;
import com.meli.desafio1.web.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
    @ExceptionHandler(UserAlreadyFollowedException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserAlreadyFollowedException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserNotFollowedException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserNotFollowedException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserOrderNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserOrderNotValidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(FollowActionInvalidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(FollowActionInvalidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
