package com.socialmeli.socialmeli.controllers;
import com.socialmeli.socialmeli.exceptions.DateIsNotValidException;
import com.socialmeli.socialmeli.exceptions.PostIdAlreadyExistException;
import com.socialmeli.socialmeli.services.dtos.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

    @ExceptionHandler(PostIdAlreadyExistException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostIdAlreadyExistException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(DateIsNotValidException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(DateIsNotValidException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }


}
