package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class DentistNotAvailableException extends MuelitasException {

    public DentistNotAvailableException(Long dentistId) {
        super("Dentist with id: " + dentistId + " doesn't have availability", HttpStatus.BAD_REQUEST);
    }
}
