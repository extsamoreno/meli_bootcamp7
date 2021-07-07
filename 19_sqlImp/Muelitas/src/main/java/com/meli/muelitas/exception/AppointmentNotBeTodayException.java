package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class AppointmentNotBeTodayException extends MuelitasException{

    public AppointmentNotBeTodayException() {
        super("Appointment couldn't be assign on today", HttpStatus.BAD_REQUEST);
    }
}
