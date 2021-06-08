package com.example.SocialMeli.Controllers;


import com.example.SocialMeli.Exceptions.PostIdInUseException;
import com.example.SocialMeli.Exceptions.PostNotFoundException;
import com.example.SocialMeli.Services.DTOs.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class PostExceptionController {

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(PostIdInUseException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(PostIdInUseException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
