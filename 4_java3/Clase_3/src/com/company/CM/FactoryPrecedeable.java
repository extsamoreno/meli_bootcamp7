package com.company.CM;

public class FactoryPrecedeable {

    public static Precedable generarPrecedeable(String nombre, int edad){
        return new Persona(nombre,edad);

    }
    public static Precedable generarPrecedeable( int numero,String titular){
        return new Celular(numero,titular);

    }

}
