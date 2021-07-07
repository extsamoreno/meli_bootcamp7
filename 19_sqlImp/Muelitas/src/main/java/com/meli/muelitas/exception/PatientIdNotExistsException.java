package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class PatientIdNotExistsException extends MuelitasException {

    public PatientIdNotExistsException(Long patientId) {
        super("PatientId " + patientId + " doesn't exists", HttpStatus.BAD_REQUEST);
    }
}
