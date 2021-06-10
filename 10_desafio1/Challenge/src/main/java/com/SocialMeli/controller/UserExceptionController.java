 package com.SocialMeli.controller;

import com.SocialMeli.exceptions.UserIdNotFoundException;
import jdk.jshell.spi.ExecutionControl;
import com.SocialMeli.exceptions.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

 @ControllerAdvice
public class UserExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(ExecutionControl.UserException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UsersCantFollowThemselvesException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UsersCantFollowThemselvesException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}