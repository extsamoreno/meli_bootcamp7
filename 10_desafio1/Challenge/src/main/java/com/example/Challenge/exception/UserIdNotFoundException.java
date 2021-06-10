package com.example.Challenge.exception;

import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends ProgramException {
    public UserIdNotFoundException(Integer idUser) {
        super("Id:  "+ idUser+" does not correspond to any user", HttpStatus.BAD_REQUEST);
    }
}
