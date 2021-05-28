package com.company.CM;

public class Celular implements Precedable<Celular>{
    private String Titular;
    private int Numero;

    public Celular( int numero,String titular) {
        Titular = titular;
        Numero = numero;
    }

    public Celular() {
    }

    public Celular(int numero) {
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String titular) {
        Titular = titular;
    }

    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    @Override
    public int precedeA(Celular celular) {
        return this.getNumero() < celular.getNumero() ? 0 : 1;
    }

    @Override
    public String toString() {
        return "Celular{" +
                "Titular='" + Titular + '\'' +
                ", Numero=" + Numero +
                '}';
    }
}
