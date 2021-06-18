package com.desafio.TuCasitaTasacionesApp.model.exceptions;

import org.springframework.http.HttpStatus;

public class NeighborhoodNotFoundException extends PropietyException {
    public NeighborhoodNotFoundException(String subject) {
        super("El barrio : " + subject + " no se encuentra registrado", HttpStatus.BAD_REQUEST);
    }
}