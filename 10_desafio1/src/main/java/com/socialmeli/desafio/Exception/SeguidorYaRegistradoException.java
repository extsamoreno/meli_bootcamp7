package com.socialmeli.desafio.Exception;

import org.springframework.http.HttpStatus;

public class SeguidorYaRegistradoException extends UserException{


    public SeguidorYaRegistradoException(int id) {
        super("El usuario id: "+id+" ya sigue al vendedor", HttpStatus.BAD_REQUEST);
    }
}
