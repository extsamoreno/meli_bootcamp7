package com.meli.desafio2.exceptions;


public class DistrictNotFoundException extends RuntimeException {
    //Excepción que se lanza cuando el nombre de un distrito o el precio de un distrito no se encuentra en el archivo Json del distrito.
    public DistrictNotFoundException(String message){
        super(message);
    }
}
