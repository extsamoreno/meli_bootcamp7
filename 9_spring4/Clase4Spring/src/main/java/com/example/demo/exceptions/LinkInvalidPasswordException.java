package com.example.demo.exceptions;
import org.springframework.http.HttpStatus;

public class LinkInvalidPasswordException extends ResponseException {
    public LinkInvalidPasswordException() {
        super("La contraseña es insegura, debe ingresar al menos un numero, una letra.", HttpStatus.NOT_FOUND);
    }
}
