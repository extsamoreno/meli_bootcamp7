package com.meli.consultorio.exceptions;

import org.springframework.http.HttpStatus;

public class ScheduleNotFoundException extends ApiException{
    public ScheduleNotFoundException(Long id) {
        super("The id " + id + " does not belong to a registered schedule", HttpStatus.NOT_FOUND);
    }
}
