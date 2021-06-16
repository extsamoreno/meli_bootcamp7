package com.company.ejercicios;

public class Contador {

    int valor;

    public Contador(int valor){
        this.valor = valor;
    }

    public Contador(Contador contador){
        contador.getValor();
    }

    public Contador(){

    }

    public void incrementar(){
        this.valor += 1;
    }

    public void decrementar(){
        this.valor -= 1;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
