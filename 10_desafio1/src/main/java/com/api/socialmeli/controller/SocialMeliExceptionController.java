package com.api.socialmeli.controller;

import com.api.socialmeli.dto.ErrorDTO;
import com.api.socialmeli.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(SocialMeliException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(NotFoundIdException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(NotFoundIdException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(EqualsIdException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(EqualsIdException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(PostIdExistsException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostIdExistsException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
    @ExceptionHandler(IsNotaFollowerException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(IsNotaFollowerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
