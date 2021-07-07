package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class DentistAvailabilityNotExistsException extends MuelitasException {

    public DentistAvailabilityNotExistsException(String dayOfWeek, Long dentistId) {
        super("DentistId " + dentistId + " doesn't have availability on " + dayOfWeek, HttpStatus.BAD_REQUEST);
    }
}
