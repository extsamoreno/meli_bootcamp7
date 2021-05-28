package com.ejercicios;

public class Celular implements Precedable<Celular> {
    private long numero;
    private String titular;

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return this.titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Celular(String titular, long numero) {
        this.titular = titular;
        this.numero = numero;
    }

    @Override
    public int precedeA(Celular celular) {
        if(this.numero > celular.numero)
            return 1;

        return 0;
    }
}
