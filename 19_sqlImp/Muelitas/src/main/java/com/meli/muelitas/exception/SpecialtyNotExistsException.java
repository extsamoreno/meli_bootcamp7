package com.meli.muelitas.exception;

import com.meli.muelitas.model.Specialty;
import org.springframework.http.HttpStatus;

public class SpecialtyNotExistsException extends MuelitasException {
    public SpecialtyNotExistsException(Long specialtyId) {
        super("SpecialtyId " + specialtyId + " doesn't exists", HttpStatus.BAD_REQUEST);
    }
}
