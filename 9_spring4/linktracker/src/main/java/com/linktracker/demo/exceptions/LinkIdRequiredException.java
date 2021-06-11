package com.linktracker.demo.exceptions;

import org.springframework.http.HttpStatus;

public class LinkIdRequiredException extends ResponseException{
    public LinkIdRequiredException() {
        super("El id es requerido.", HttpStatus.BAD_REQUEST);
    }
}
