package com.meli.tucasitatasaciones.exception;

import org.springframework.http.HttpStatus;

public class PropertyNotFoundException extends ApiException {
    public PropertyNotFoundException(Integer id) {
        super("El id " + id + " no pertenece a una propiedad registrada", HttpStatus.NOT_FOUND);
    }
}
