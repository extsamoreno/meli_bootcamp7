package com.meli.consultorio.exceptions;

import org.springframework.http.HttpStatus;

public class PatientNotFoundException extends ApiException {
    public PatientNotFoundException(Long id) {
        super("The id " + id + " does not belong to a registered patient", HttpStatus.NOT_FOUND);
    }
}
