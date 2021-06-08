package com.example.demo.controller;

import com.example.demo.DTO.ErrorDTO;
import com.example.demo.exception.FollowersNotFoundException;
import com.example.demo.exception.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerException {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FollowersNotFoundException.class)
    public ResponseEntity<ErrorDTO> followersNotFoundException(FollowersNotFoundException e){
        return new ResponseEntity<>(e.getError(),HttpStatus.BAD_REQUEST);
    }

}
