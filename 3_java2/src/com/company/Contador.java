package com.company;

public class Contador {

    private int valor;

    public int getValor() {
        return valor;
    }

    public Contador() {}

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador copia) {
        this.valor = copia.getValor();
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void incrementar(){
        valor++;
    }

    public void decrementar(){
        valor--;
    }
}
