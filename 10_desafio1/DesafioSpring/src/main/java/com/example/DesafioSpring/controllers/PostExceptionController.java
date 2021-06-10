package com.example.DesafioSpring.controllers;

import com.example.DesafioSpring.dto.ErrorMsgDTO;
import com.example.DesafioSpring.exceptions.PostNotFoundException;
import com.example.DesafioSpring.exceptions.PostTakenException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PostExceptionController {
    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorMsgDTO> handleGlobalException(PostNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PostTakenException.class)
    public ResponseEntity<ErrorMsgDTO> handleGlobalException(PostTakenException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
