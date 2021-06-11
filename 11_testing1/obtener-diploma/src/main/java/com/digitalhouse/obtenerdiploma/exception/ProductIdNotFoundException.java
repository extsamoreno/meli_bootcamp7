package com.digitalhouse.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;

public class ProductIdNotFoundException extends ObtenerDiplomaException {
    public ProductIdNotFoundException(Integer idProduct) {
        super("El id: "+idProduct+" no corresponde a ningun Product", HttpStatus.BAD_REQUEST);
    }
}
