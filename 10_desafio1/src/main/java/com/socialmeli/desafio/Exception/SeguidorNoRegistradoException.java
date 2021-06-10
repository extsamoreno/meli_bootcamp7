package com.socialmeli.desafio.Exception;

import org.springframework.http.HttpStatus;

public class SeguidorNoRegistradoException extends UserException {

    public SeguidorNoRegistradoException(int userId, int vendedorId) {
        super("El usuario id: "+userId+" no sigue al vendedor id: " + vendedorId, HttpStatus.BAD_REQUEST);
    }
}
