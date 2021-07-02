package com.example.CalculadoraMetrosCuadrados.exceptions;

/*
* Exception that is thrown when either a district's name or
* a district's price is not found in the districts Json file.
*/
public class DistrictNotFoundException extends RuntimeException{

    public DistrictNotFoundException(String message){
        super(message);
    }
}
