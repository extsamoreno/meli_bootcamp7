package com.digitalhouse.obtenerdiploma.exceptions;

import org.springframework.http.HttpStatus;

public class SubjectNameNotFoundException extends SubjectException {
    public SubjectNameNotFoundException(String subject) {
        super("La materia : " + subject + " no corresponde a ninguna materia dictada en esta escuela", HttpStatus.BAD_REQUEST);
    }
}