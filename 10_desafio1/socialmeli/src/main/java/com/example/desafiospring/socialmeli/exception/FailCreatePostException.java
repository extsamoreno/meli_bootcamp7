package com.example.desafiospring.socialmeli.exception;

import com.example.desafiospring.socialmeli.service.DTO.ErrorDTO;
import org.springframework.http.HttpStatus;

public class FailCreatePostException extends UserException {
    public FailCreatePostException(){
        super(new ErrorDTO("Fail Create Post Exception","Fallo la creacion"), HttpStatus.BAD_REQUEST);
    }
}
