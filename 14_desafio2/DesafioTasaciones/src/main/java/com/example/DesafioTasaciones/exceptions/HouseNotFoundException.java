package com.example.DesafioTasaciones.exceptions;
import org.springframework.http.HttpStatus;
public class HouseNotFoundException extends ErrorException {
    public HouseNotFoundException(Integer id) {
        super("El id " + id + " no pertenece a una propiedad registrada", HttpStatus.NOT_FOUND);
    }
}
