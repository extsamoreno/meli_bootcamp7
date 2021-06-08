package com.exceptions;

import com.models.ErrorDTO;
import org.springframework.http.HttpStatus;

public class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super(new ErrorDTO("Wrong Password", "La contraseña es incorrecta "), HttpStatus.FORBIDDEN);
    }
}
