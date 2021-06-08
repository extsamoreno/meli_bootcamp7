package com.example.demo.project.exception;

import org.springframework.http.HttpStatus;

public class UrlIdNotFoundException extends UrlException {
    public UrlIdNotFoundException(Integer idUrl) {
        super("El id: "+idUrl+" no corresponde a ninguna URL", HttpStatus.NOT_FOUND);
    }
}
