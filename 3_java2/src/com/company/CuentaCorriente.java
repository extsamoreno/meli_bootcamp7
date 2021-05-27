package com.company;

public class CuentaCorriente {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente() {

    }
    public CuentaCorriente(double saldo){
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuenta){
        this.saldo = cuenta.saldo;
    }

    public void ingreso(double monto){
        this.saldo += monto;
    }

    public void egreso(double monto){
        this.saldo -= monto;
    }

    public void reintegro(CuentaCorriente cuenta,double monto){
        this.saldo += monto;
    }

    public void transferencia(CuentaCorriente cuenta,double monto){
        this.saldo -= monto;
        cuenta.setSaldo(cuenta.getSaldo() + monto);
    }
}
