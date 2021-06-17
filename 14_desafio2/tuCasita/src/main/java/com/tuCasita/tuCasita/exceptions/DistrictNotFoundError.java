package com.tuCasita.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class DistrictNotFoundError extends TuCasitaException{

    public DistrictNotFoundError() {
        super(new ErrorDTO("District Not Found", "No se encontro el barrio solicitado"), HttpStatus.NOT_FOUND);
    }

}
