package com.ejercitacion;

public class Contador {

    private int contador;

    public Contador(int contador) {
        this.contador = contador;
    }

    public Contador() {
    }

    public Contador(Contador cont) {
        this.contador = cont.getContador();
    }

    public void incrementar() {
        this.contador += 1;
    }

    public void decrementar() {
        this.contador -= 1;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
