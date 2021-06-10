package com.socialmeli.desafio.Exception;

import org.springframework.http.HttpStatus;

public class VendedorIdNotFoundException extends UserException {

    public VendedorIdNotFoundException(int id) {
        super("El id: "+id+" no corresponde a ningun vendedor", HttpStatus.BAD_REQUEST);
    }


}
