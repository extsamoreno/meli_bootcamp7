package com.tuCasita.tuCasita.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class TuCasitaException extends RuntimeException{

    private ErrorDTO error;
    private HttpStatus status;
}
