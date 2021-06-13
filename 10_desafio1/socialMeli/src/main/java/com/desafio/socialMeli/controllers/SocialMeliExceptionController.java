package com.desafio.socialMeli.controllers;

import com.desafio.socialMeli.model.exceptions.RemoveFollowedException;
import com.desafio.socialMeli.model.exceptions.RemoveFollowerException;
import com.desafio.socialMeli.model.exceptions.RepositoryUnableException;
import com.desafio.socialMeli.model.exceptions.UserNotFoundException;
import com.desafio.socialMeli.model.dto.ErrorDTO;
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
