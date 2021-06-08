package com.example.MeliSocialApi.project.controller;

import com.example.MeliSocialApi.project.exception.UserException;
import com.example.MeliSocialApi.project.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserControllerException {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserException e){
        return new ResponseEntity<ErrorDTO>(e.getError(),e.getStatus());
    }
/*
    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkIdNotFoundException e){

        return new ResponseEntity<>(e.getError(),e.getStatus());
    }*/
}