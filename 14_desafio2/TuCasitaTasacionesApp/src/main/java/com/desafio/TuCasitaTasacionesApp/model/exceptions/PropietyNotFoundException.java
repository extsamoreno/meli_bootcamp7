package com.desafio.TuCasitaTasacionesApp.model.exceptions;

import org.springframework.http.HttpStatus;

public class PropietyNotFoundException extends PropietyException {
    public PropietyNotFoundException(String subject) {
        super("La propiedad : " + subject + " no se encuentra registrada", HttpStatus.BAD_REQUEST);
    }
}