package com.meli.consultorio.exceptions;

import org.springframework.http.HttpStatus;

public class AppointmentNotFoundException extends ApiException {
    public AppointmentNotFoundException(Long id) {
        super("The id " + id + " does not belong to a registered appointment", HttpStatus.NOT_FOUND);
    }
}
