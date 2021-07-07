package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class DentistNotExistsException extends MuelitasException {

    public DentistNotExistsException(Long dentistId, String dentistName) {
        super("Dentist id " + (dentistId!=null?dentistId:dentistName) + " not found", HttpStatus.BAD_REQUEST);
    }
}
