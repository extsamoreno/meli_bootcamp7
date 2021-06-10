package com.example.desafio1.controllers.exceptions;

import com.example.desafio1.dtos.ErrorDTO;
import com.example.desafio1.exceptions.user.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(InvalidUserIdException.class)
    public ResponseEntity<ErrorDTO> handlerInvalidUserIdException(InvalidUserIdException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<ErrorDTO> handlerInvalidOrderUserException(InvalidOrderException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(AlreadyFollowException.class)
    public ResponseEntity<ErrorDTO> handlerAlreadyFollowException(AlreadyFollowException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(SelfFollowUnFollowException.class)
    public ResponseEntity<ErrorDTO> handlerSelfFollowUnFollowException(SelfFollowUnFollowException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }

    @ExceptionHandler(NotFollowedException.class)
    public ResponseEntity<ErrorDTO> handlerNotFollowedException(NotFollowedException e) {
        return new ResponseEntity<>(e.getError(), e.getStatus());
    }
}
