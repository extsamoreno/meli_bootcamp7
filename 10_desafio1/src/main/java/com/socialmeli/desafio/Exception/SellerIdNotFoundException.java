package com.socialmeli.desafio.Exception;

import org.springframework.http.HttpStatus;

public class SellerIdNotFoundException extends UserException {

    public SellerIdNotFoundException(int id) {
        super("El id: "+id+" no corresponde a ningun vendedor", HttpStatus.BAD_REQUEST);
    }


}
