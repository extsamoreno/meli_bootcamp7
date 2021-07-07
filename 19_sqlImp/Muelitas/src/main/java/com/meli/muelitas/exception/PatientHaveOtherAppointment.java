package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class PatientHaveOtherAppointment extends MuelitasException {
    public PatientHaveOtherAppointment(String patientName) {
        super("Patient " + patientName + " have a appointment at the same time", HttpStatus.BAD_REQUEST);
    }
}
