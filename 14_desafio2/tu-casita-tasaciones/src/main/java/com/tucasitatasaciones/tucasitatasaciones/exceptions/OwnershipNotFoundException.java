package com.tucasitatasaciones.tucasitatasaciones.exceptions;

import org.springframework.http.HttpStatus;

public class OwnershipNotFoundException extends TuCasitaException {
    public OwnershipNotFoundException(int ownershipId) {
        super("No se encuentra la propiedad con el id: " + ownershipId, HttpStatus.NOT_FOUND);
    }
}
