package com.ejercitacion;

public class CuentaCorriente {

    private double saldo;

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente() {
    }

    public CuentaCorriente(CuentaCorriente cta) {
        this.saldo = cta.getSaldo();
    }

    public void ingreso(double monto) {
       this.saldo += monto;
    }

    public void egreso(double monto) {
        this.saldo -= monto;
    }

    public void reintegro(double monto) {
       this.saldo += monto;
    }

    public void transferencia(double monto, CuentaCorriente cta) {
        this.saldo -= monto;
        cta.setSaldo(cta.getSaldo() + monto);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
