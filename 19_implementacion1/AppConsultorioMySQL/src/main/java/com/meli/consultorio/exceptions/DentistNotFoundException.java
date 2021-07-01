package com.meli.consultorio.exceptions;

import org.springframework.http.HttpStatus;

public class DentistNotFoundException extends ApiException {
    public DentistNotFoundException(Long id) {
        super("The id " + id + " does not belong to a registered dentist", HttpStatus.NOT_FOUND);
    }
}
