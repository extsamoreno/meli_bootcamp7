package com.company;

import javax.swing.event.CellEditorListener;

public class Celular implements  Precedable<Celular>{

    private int numero;
    private String titular;

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
//        devuelve <0, entonces la cadena que llama al método es primero lexicográficamente
//        devuelve == 0 entonces las dos cadenas son lexicográficamente equivalentes
//        devuelve> 0, entonces el parámetro pasado al método compareTo es lexicográficamente el primero.
        return celular.getTitular().compareTo(this.titular);
    }

    @Override
    public String toString() {
        return "Celular{" +
                "numero=" + numero +
                ", titular='" + titular + '\'' +
                '}';
    }
}
