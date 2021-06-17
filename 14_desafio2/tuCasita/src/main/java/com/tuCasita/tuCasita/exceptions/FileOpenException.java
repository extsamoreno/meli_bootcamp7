package com.tuCasita.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class FileOpenException extends TuCasitaException {
    public FileOpenException(){
        super(new ErrorDTO("File Open Exception", "El archivo no se pudo abrir correctamente"), HttpStatus.BAD_REQUEST);
    }
}
