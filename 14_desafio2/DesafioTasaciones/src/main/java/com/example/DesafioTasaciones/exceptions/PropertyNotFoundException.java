package com.example.DesafioTasaciones.exceptions;
import org.springframework.http.HttpStatus;
public class PropertyNotFoundException extends ErrorException {
    public PropertyNotFoundException(Integer id) {
        super("El id " + id + " no pertenece a una propiedad registrada", HttpStatus.NOT_FOUND);
    }
}
