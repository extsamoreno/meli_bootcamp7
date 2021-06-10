package com.socialmeli.desafio.Exception;

import org.springframework.http.HttpStatus;

public class UserIdNotFoundException extends UserException {

    public UserIdNotFoundException(int id) {
        super("El id: "+id+" no corresponde a ningun usuario", HttpStatus.BAD_REQUEST);
    }


}
