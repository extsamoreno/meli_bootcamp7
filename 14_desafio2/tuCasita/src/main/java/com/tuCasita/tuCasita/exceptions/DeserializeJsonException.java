package com.tuCasita.tuCasita.exceptions;

import org.springframework.http.HttpStatus;

public class DeserializeJsonException extends TuCasitaException {
    public DeserializeJsonException(){
        super(new ErrorDTO("Deserialize Json Exception", "Los datos del archivo no son compatibles con los del modelo"), HttpStatus.BAD_REQUEST);
    }
}
