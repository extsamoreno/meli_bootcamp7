package com.example.spring4.exceptions;

import org.springframework.http.HttpStatus;

public class URLNotFoundException extends LinkException {
    public URLNotFoundException(Integer id) {
        super("No hay URL para el id: " + id, HttpStatus.NOT_FOUND);
    }
}
