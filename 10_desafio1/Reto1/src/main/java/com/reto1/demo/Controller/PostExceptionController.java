package com.reto1.demo.Controller;

import com.reto1.demo.Exception.PostException.DuplicatedPostException;
import com.reto1.demo.Model.DTO.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

    @ExceptionHandler(DuplicatedPostException.class)
    public ResponseEntity<ErrorDTO> handleException(DuplicatedPostException e){
        return new ResponseEntity(e.getError(), e.getStatus());
    }



}
