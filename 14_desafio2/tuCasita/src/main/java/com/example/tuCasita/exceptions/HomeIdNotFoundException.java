package com.example.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class HomeIdNotFoundException extends HomeException{
    public HomeIdNotFoundException(Integer homeId){
        super("The home " + homeId + " does not exist", HttpStatus.BAD_REQUEST);
    }
}
