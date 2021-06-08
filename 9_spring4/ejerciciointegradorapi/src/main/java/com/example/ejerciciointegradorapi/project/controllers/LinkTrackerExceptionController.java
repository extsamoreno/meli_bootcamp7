package com.example.ejerciciointegradorapi.project.controllers;

import com.example.ejerciciointegradorapi.project.exceptions.LinkTrackerException;
import com.example.ejerciciointegradorapi.project.exceptions.InvalidUrlException;
import com.example.ejerciciointegradorapi.project.exceptions.idNotFoundException;
import com.example.ejerciciointegradorapi.project.services.Dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.MalformedURLException;

@ControllerAdvice
public class LinkTrackerExceptionController {

    @ExceptionHandler(LinkTrackerException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkTrackerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(InvalidUrlException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(InvalidUrlException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(idNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(idNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }



/*    @ExceptionHandler(MalformedURLException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(LinkTrackerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }*/
}

