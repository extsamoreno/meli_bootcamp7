package ejercicio1;

public class FactoryPrecedable<T> {
    public static ejercicio1.Precedable<ejercicio1.Persona> generarPrecedable(String nombre, int dni){
        return new ejercicio1.Persona(nombre, dni);
    }

    public static ejercicio1.Precedable<ejercicio1.Celular> generarPrecedable(int numero, String titular){
        return new ejercicio1.Celular(titular, numero);
    }

}