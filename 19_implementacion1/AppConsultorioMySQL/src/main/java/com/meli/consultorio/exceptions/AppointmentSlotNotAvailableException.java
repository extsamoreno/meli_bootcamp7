package com.meli.consultorio.exceptions;

import org.springframework.http.HttpStatus;

public class AppointmentSlotNotAvailableException extends ApiException {
    public AppointmentSlotNotAvailableException() {
        super("The dentist does not work in that time slot", HttpStatus.NOT_FOUND);
    }
}
