package com.company.ej1;

public class FactoryPrecedable<T> {
/*
    public static Precedable generarPrecedable(String nombre, int dni) {
        return new Persona(nombre, dni);
    }
*/
    public static Precedable<Persona> generarPrecedable(String nombre, int dni) {
        return new Persona(nombre, dni);
    }

    public static Precedable<Celular> generarPrecedable(int nro, String titular) {
        return new Celular(nro, titular);
    }

}
