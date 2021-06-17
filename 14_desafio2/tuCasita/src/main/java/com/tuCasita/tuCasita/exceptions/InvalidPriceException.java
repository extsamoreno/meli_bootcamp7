package com.tuCasita.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class InvalidPriceException extends TuCasitaException{

    public InvalidPriceException() {
        super(new ErrorDTO("Invalid Price", "El precio no se corresponde con el barrio solicitado"), HttpStatus.BAD_REQUEST);
    }
}
