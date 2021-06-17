package com.example.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistEnviromentIdException extends HomeException{
    public AlreadyExistEnviromentIdException(Integer enviromentId) {
        super("The enviroment " + enviromentId + " already exist", HttpStatus.BAD_REQUEST);
    }
}
