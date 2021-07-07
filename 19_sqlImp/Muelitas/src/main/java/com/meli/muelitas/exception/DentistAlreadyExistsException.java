package com.meli.muelitas.exception;

import org.springframework.http.HttpStatus;

public class DentistAlreadyExistsException extends MuelitasException {

    public DentistAlreadyExistsException(String dentistName) {
        super("Dentist " + dentistName + " already found", HttpStatus.BAD_REQUEST);
    }
}
