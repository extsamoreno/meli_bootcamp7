package com.meli;

public class Contador {

    private int valor;

    public Contador() {
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador contador) {
        this.valor = contador.getValor();
    }

    public void incrementar (int valor) {
        this.valor = this.valor + valor;
    }

    public void decrementar(int valor) {
        this.valor = this.valor - valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
