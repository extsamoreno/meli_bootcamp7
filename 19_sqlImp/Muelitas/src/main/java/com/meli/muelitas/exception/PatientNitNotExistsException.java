package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class PatientNitNotExistsException extends MuelitasException {

    public PatientNitNotExistsException(String patientNit) {
        super("PatientNit " + patientNit + " doesn't exists", HttpStatus.BAD_REQUEST);
    }
}
