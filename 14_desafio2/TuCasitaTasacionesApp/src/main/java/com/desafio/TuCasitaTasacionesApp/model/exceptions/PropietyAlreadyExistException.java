package com.desafio.TuCasitaTasacionesApp.model.exceptions;

import org.springframework.http.HttpStatus;

public class PropietyAlreadyExistException extends PropietyException {
    public PropietyAlreadyExistException(String subject) {
        super("La propiedad : " + subject + " ya se encuentra registrada", HttpStatus.BAD_REQUEST);
    }
}