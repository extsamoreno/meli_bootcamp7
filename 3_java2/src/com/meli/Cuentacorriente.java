package com.meli;

class CuentaCorriente {

    private String titular;
    private double saldo;

    public CuentaCorriente() {
        this.titular = "";
        this.saldo = 0.00;
    }

    public CuentaCorriente(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cc) {
        this.titular = cc.titular;
        this.saldo = cc.saldo;
    }

    public void ingreso (double cantidad) {
        this.saldo += cantidad;
    }

    public void egreso (double cantidad) {
        this.saldo -= cantidad;
    }

    public void reintegro (double cantidad) {
        ingreso(cantidad);
    }

    // yo le transfiero a otro
    public void transferencia (CuentaCorriente cc, double cantidad) {
        egreso(cantidad);
        cc.saldo += cantidad;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}