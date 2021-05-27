package com.ejercicioMañana;
//Crea una clase Contador (sí, contador de programación) con métodos que permitan incrementar y decrementar su valor. La clase contendrá un constructor por defecto, un constructor con parámetros, un constructor copia y los setters y getters (métodos de acceso) que corresponda.
public class Contador {
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Contador() {
    }

    public Contador(int value) {
        this.value = value;
    }

    public Contador(Contador contador) {
        this.value = contador.getValue();
    }

    public void incrementar(int cantidad){
        this.value += cantidad;
    }
    public void decrementar(int cantidad){
        this.value -= cantidad;
    }
}
