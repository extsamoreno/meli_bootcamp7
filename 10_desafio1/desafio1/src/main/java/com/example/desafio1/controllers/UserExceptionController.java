package com.example.desafio1.controllers;

import com.example.desafio1.dtos.ErrorDTO;
import com.example.desafio1.exceptions.FollowingAlreadyExistsException;
import com.example.desafio1.exceptions.FollowingDoesNotExistException;
import com.example.desafio1.exceptions.OrderNotValidException;
import com.example.desafio1.exceptions.UserIdNotValidException;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController{

    @ExceptionHandler(UserIdNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdNotValidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(FollowingAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(FollowingAlreadyExistsException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(FollowingDoesNotExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(FollowingDoesNotExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(OrderNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(OrderNotValidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
