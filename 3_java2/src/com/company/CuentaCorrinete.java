package com.company;

public class CuentaCorrinete {
    private double saldo;


    public CuentaCorrinete() {
        this.saldo = 0;
    }
    public CuentaCorrinete(CuentaCorrinete cuenta) {
        this.saldo = cuenta.getSaldo();
    }

    public double getSaldo() {
        return this.saldo;
    }


    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double valor){
        this.saldo = this.saldo + valor;
    }

    public void egreso(double valor){
        if (this.saldo> valor){
            this.saldo = this.saldo - valor;
        }

    }

    public void reintegro(double valor){
        this.saldo = this.saldo + valor;
    }

    public void transferencia(double valor){
        this.saldo = this.saldo + valor;
    }
}
