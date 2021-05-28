package meli.ejerc;

public class FactoryPrecedable<T> {
    public static Precedable<Persona> generarPrecedable(String nombre, int dni){
        return new Persona(nombre, dni);
    }

    public static Precedable<Celular> generarPrecedable(int numero, String titular){
        return new Celular(titular, numero);
    }

}
