package com.example.demo.project.exception;

import org.springframework.http.HttpStatus;

import java.time.LocalDate;

public class CantInsertDateGreaterThanToday extends PublicationException {
    public CantInsertDateGreaterThanToday(LocalDate date) {
        super("La a fecha: "+date+" no es valida", HttpStatus.BAD_REQUEST);
    }
}
