package com.example.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class HomeWithNoEnviromentsException extends HomeException{
    public HomeWithNoEnviromentsException(Integer homeId) {
        super("The home " + homeId + " does not have any enviroments", HttpStatus.BAD_REQUEST);
    }
}
