package com.ejercitacion.mañana;

public class Celular implements Precedable<Celular> {

    private String titular;
    private int numero;

    public Celular(String titular, int numero) {
        this.titular = titular;
        this.numero = numero;
    }

    public Celular() {
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
    public int precedeA(Celular celular) {
        return this.numero - celular.getNumero();
    }

    @Override
    public String toString() {
        return "Celular{" +
                "titular='" + titular + '\'' +
                ", numero=" + numero +
                '}';
    }
}
