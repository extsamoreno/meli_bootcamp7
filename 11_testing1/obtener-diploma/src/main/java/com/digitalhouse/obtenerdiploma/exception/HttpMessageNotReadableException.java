package com.digitalhouse.obtenerdiploma.exception;

import org.springframework.http.HttpStatus;

public class HttpMessageNotReadableException extends AnalyzeNotesException {
    public HttpMessageNotReadableException(Integer idProduct) {
        super("El id: "+idProduct+" no corresponde a ningun Product", HttpStatus.BAD_REQUEST);
    }
}
