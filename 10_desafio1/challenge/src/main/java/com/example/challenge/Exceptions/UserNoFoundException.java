package com.example.challenge.Exceptions;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;

public class UserNoFoundException extends UserException {
    public UserNoFoundException(int userId) {
        super("User: "+userId+" not found", HttpStatus.BAD_REQUEST);
    }
}
