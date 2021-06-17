package com.desafio.TuCasitaTasacionesApp.model.exceptions;

import org.springframework.http.HttpStatus;

public class PropietyNameAlreadyExistException extends PropietyException {
    public PropietyNameAlreadyExistException(String subject) {
        super("La propiedad : " + subject + " ya se encuentra registrada", HttpStatus.BAD_REQUEST);
    }
}