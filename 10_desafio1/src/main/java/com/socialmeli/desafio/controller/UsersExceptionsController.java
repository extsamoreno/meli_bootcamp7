package com.socialmeli.desafio.controller;

import com.socialmeli.desafio.Exception.FollowerNotRegisteredException;
import com.socialmeli.desafio.Exception.RegisteredFollowerException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.SellerIdNotFoundException;
import com.socialmeli.desafio.dto.ErrorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UsersExceptionsController {


    @ExceptionHandler(UserIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> UserGlobalException(UserIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(SellerIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> VendedorGlobalException(SellerIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(RegisteredFollowerException.class)
    public ResponseEntity<ErrorDTO> UserGlobalException(RegisteredFollowerException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(FollowerNotRegisteredException.class)
    public ResponseEntity<ErrorDTO> UserGlobalException(FollowerNotRegisteredException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
