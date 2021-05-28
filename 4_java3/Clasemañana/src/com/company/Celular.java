package com.company;
public class Celular implements Precedeable <Celular> {
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    private int numero;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    private String titular;

    public Celular(){}

    @Override
    public String toString() {
        return "Celular{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                '}';
    }

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }
        @Override
        public int precedeA(Celular celular) {
            return this.numero - celular.getNumero();
        }

    }

