package com.example.tucasita.exception;

import org.springframework.http.HttpStatus;

public class InvalidPropertyException extends PropertyException{
    public InvalidPropertyException(String districtName) {
        super("No es posible crear la propiedad que usted desea ya que el barrio " + districtName + " no existe en el repositorio local.", HttpStatus.BAD_REQUEST);
    }
}
