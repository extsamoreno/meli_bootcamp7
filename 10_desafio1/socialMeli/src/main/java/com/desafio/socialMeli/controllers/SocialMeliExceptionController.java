package com.desafio.socialMeli.controllers;

import com.desafio.socialMeli.exceptions.RemoveFollowedException;
import com.desafio.socialMeli.exceptions.RemoveFollowerException;
import com.desafio.socialMeli.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.exceptions.UserNotFoundException;
import com.desafio.socialMeli.service.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SocialMeliExceptionController {

    @ExceptionHandler(RepositoryUnableException.class)
    public ResponseEntity<ErrorDTO> handleGlobalException(RepositoryUnableException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> handleDisableException(UserNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(RemoveFollowedException.class)
    public ResponseEntity<ErrorDTO> handleDisableException(RemoveFollowedException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(RemoveFollowerException.class)
    public ResponseEntity<ErrorDTO> handleDisableException(RemoveFollowerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }
}
