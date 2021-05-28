package com.company.Clase2JavaTM;

public class Contador {

    private int numero;

    public void incrementar(){
        this.numero++;
    }
    public void decrementar(){
        this.numero--;
    }

    public Contador(){
    }

    public Contador(int numero){
        this.numero=numero;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public static void main(String[] args) {

        Contador contador = new Contador();

        contador.setNumero(0);

        contador.incrementar();

        System.out.println(contador.numero);

    }
}


