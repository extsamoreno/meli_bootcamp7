package com.example.DesafioSpring.controllers;

import com.example.DesafioSpring.dto.ErrorMsgDTO;
import com.example.DesafioSpring.exceptions.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorMsgDTO> handleGlobalException(UserNotFoundException e){
        return new ResponseEntity<>(e.getErrorMsg(),e.getStatus());
    }
    }


