package com.company;

public class Celular implements Precedable<Celular> {

    //Propiedades
    private int numero;
    private String titular;

    //Getters y setters
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

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    //Metodos
    @Override
    public int precedeA(Celular celular) {
        int celularNumero = celular.getNumero();

        if (this.numero > celularNumero) return 1; //Es mayor el nuestro
        if (this.numero < celularNumero) return -1; //Es menor el nuestro

        return 0; //Si no es mayor y no es menor, es igual
    }

    @Override
    public String toString() {
        return  "{ titular : '" + this.titular + "', numero : '" + this.numero + "' }";
    }
}
