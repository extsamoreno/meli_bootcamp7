package com.example.demo.exceptions;

import org.springframework.http.HttpStatus;

public class AppoimentNotFoundException extends MuelitasException{

    public AppoimentNotFoundException(Long id) {
        super("La cita con id "+id+" no se encuentra registrada.", HttpStatus.BAD_REQUEST);
    }
}
