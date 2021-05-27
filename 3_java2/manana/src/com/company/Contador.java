package com.company;

public class Contador {
    private int status;

    public Contador() {
    }

    public Contador(int status) {
        this.status = status;
    }

    public Contador(Contador copiado) {
        this.status = copiado.status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void sumarUno() {
        this.status++;
    }

    public void restarUno() {
        this.status--;
    }

    public void sumar(int i) {
        this.status += i;
    }

    public void restar(int i) {
        this.status -= i;
    }
}
