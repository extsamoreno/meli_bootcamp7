package com.company.ej2;

public class Contador {

    private int nro;

    public Contador() {
        this.nro = 0;
    }

    public Contador(int nro) {
        this.nro = nro;
    }

    public Contador(Contador contador) {
        this.nro = contador.nro;
    }

    public void incrementar() {
        this.nro += 1;
    }

    public void incrementar(int n) {
        this.nro += n;
    }

    public void decrementar() {
        this.nro -= 1;
    }

    public void decrementar(int n) {
        this.nro -= n;
    }

    public int getNro() {
        return nro;
    }

    public void setNro(int nro) {
        this.nro = nro;
    }

}
