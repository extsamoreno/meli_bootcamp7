package com.bootcamp;

public class CuentaCorriente {
    private double saldo;

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.saldo = cuentaCorriente.getSaldo();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double cantidad) {
        this.saldo += cantidad;
    }

    public boolean egreso(double cantidad) {
        if (cantidad <= this.saldo) {
            this.saldo -= cantidad;
            return true;
        }

        return false;
    }

    public void reintegro(double monto) {
        this.ingreso(monto);
    }

    public void transferencia(CuentaCorriente cuentaReceptora, double monto) {
        cuentaReceptora.ingreso(monto);
    }

}
