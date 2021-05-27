package com.company;

public class Contador {
    //Propiedades
    private int iterador;

    //Getters y setters
    public int getIterador() {
        return iterador;
    }

    public void setIterador(int iterador) {
        this.iterador = iterador;
    }

    //Constructores
    public Contador() {}

    public Contador(int iterador) {
        this.iterador = iterador;
    }

    public Contador(Contador contadorCopia) {
        this.iterador = contadorCopia.iterador;
    }

    //Metodos
    public void incrementar() {
        this.iterador++;
    }

    public void decrementar() {
        this.iterador--;
    }
}
