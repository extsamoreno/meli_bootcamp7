package com.example.demo.project.exception;

import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends UserException {
    public UserIdNotFoundException(Integer idUrl) {
        super("El id: "+idUrl+" no corresponde a ningun Usuario", HttpStatus.BAD_REQUEST);
    }
}
