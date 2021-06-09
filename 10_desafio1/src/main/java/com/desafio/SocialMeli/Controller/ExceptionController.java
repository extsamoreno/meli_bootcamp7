package com.desafio.SocialMeli.Controller;

import com.desafio.SocialMeli.DTO.Error.ErrorDTO;
import com.desafio.SocialMeli.Exception.SocialMeliException;
import com.desafio.SocialMeli.Exception.User.UserExistsException;
import com.desafio.SocialMeli.Exception.User.UserIdNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(SocialMeliException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserExistsException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(UserExistsException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
