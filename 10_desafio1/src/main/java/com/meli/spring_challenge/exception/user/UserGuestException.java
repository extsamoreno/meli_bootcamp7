package com.meli.spring_challenge.exception.user;

import org.springframework.http.HttpStatus;

public class UserGuestException extends UserException{
    public UserGuestException(int userID){
        super("Your userID: "+userID+" is not Authorized - Only for guest Users", HttpStatus.BAD_REQUEST);
    }

}
