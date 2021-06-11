package com.digitalhouse.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;

public class DuplicateSubjectNameException extends AnalyzeNotesException {
    public DuplicateSubjectNameException() {
        super("Los nombres de materias no se pueden repetir", HttpStatus.BAD_REQUEST);
    }
}
