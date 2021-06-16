package com.example.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class AlreadyExistHomeException extends HomeException{

    public AlreadyExistHomeException(Integer homeId){
        super("The home " + homeId + " already exist", HttpStatus.BAD_REQUEST);
    }
}
