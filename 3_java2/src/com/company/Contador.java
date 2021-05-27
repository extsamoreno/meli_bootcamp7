package com.company;

public class Contador {

    private double valor;

    public Contador() {
        this.valor = 0;
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador contador) {
        this.valor = contador.getValor();
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void incrementValor(){
        this.valor++;
    }

    public void incrementValor(double valor){
        this.valor = this.valor + valor;
    }
}
