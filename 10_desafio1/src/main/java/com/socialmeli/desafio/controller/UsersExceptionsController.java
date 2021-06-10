package com.socialmeli.desafio.controller;

import com.socialmeli.desafio.Exception.SeguidorNoRegistradoException;
import com.socialmeli.desafio.Exception.SeguidorYaRegistradoException;
import com.socialmeli.desafio.Exception.UserIdNotFoundException;
import com.socialmeli.desafio.Exception.VendedorIdNotFoundException;
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

    @ExceptionHandler(VendedorIdNotFoundException.class)
    public ResponseEntity<ErrorDTO> VendedorGlobalException(VendedorIdNotFoundException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(SeguidorYaRegistradoException.class)
    public ResponseEntity<ErrorDTO> UserGlobalException(SeguidorYaRegistradoException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

    @ExceptionHandler(SeguidorNoRegistradoException.class)
    public ResponseEntity<ErrorDTO> UserGlobalException(SeguidorNoRegistradoException e){
        return new ResponseEntity<>(e.getError(),e.getStatus());
    }

}
