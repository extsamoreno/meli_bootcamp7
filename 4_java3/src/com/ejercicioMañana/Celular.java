package com.ejercicioMañana;

public class Celular implements Precedable<Celular>{
    String titular;
    int numero;

    public Celular(String titular, int numero) {
        this.titular = titular;
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Titular: " + this.titular + " Numero: " + this.numero;
    }

    @Override
    public int precedeA(Celular celular) {
        return this.numero - celular.numero;
    }
}
