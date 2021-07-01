package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class DentistNotFoundException extends MuelitasException {

    public DentistNotFoundException(Long id) {
        super("El dentista con id "+id+" no se encuentra registrada.", HttpStatus.BAD_REQUEST);
    }

}

