package com.meli.demo.controllers;

import com.meli.demo.dtos.ErrorDTO;
import com.meli.demo.exceptions.FollowException;
import com.meli.demo.exceptions.PostDiscountException;
import com.meli.demo.exceptions.PostException;
import com.meli.demo.exceptions.SocialExcepton;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class SocialExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(SocialExcepton e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(FollowException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(FollowException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(PostException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PostDiscountException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostDiscountException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}

