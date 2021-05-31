package meli.ejerc;

import java.util.ArrayList;

public class FactoryPrecedable {
    public static Precedable generarPrecedeable(String nombre, int edad){
        return new Persona(nombre,edad);

    }
    public static Precedable generarPrecedeable( int numero,String titular){
        return new Celular(titular,numero);

    }
}
