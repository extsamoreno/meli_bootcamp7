package com.company;

public class Contador {

    private int valor;

    public int getValorInicial() {
        return valor;
    }

    public void setValorInicial(int valorInicial) {
        this.valor = valorInicial;
    }

    public Contador() {
    }

    public Contador(int valorInicial) {
        this.valor = valorInicial;
    }
    public Contador(Contador cont) {
        this.valor = cont.valor;
    }

    public void incrementar(){
        this.valor++;
    }

    public void decrementar(){
        this.valor --;
    }

}
