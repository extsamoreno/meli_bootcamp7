package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class AppointmentNotExistsException extends MuelitasException {

    public AppointmentNotExistsException(Long appointmentId) {
        super("Appointment id " + appointmentId + " not found", HttpStatus.BAD_REQUEST);
    }
}
