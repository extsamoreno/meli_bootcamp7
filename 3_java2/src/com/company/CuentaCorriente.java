package com.company;

public class CuentaCorriente {
    //Propiedades
    private double saldo;

    //Getters y setters
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //Constructores
    public CuentaCorriente () {}

    public CuentaCorriente (double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente (CuentaCorriente cuentaCorriente) {
        this.saldo = cuentaCorriente.getSaldo();
    }

    //Metodos
    public void ingreso (double ingresoMonto) {
        this.saldo = this.saldo + ingresoMonto;
    }

    public void egreso (double egresoMonto) {
        this.saldo = this.saldo - egresoMonto;
    }

    public void reintegro (double reintegroMonto) {
        this.ingreso(reintegroMonto);
    }

    //Null checks?
    public void transferencia (CuentaCorriente cuentaCorriente, double transferenciaMonto) {
        this.egreso(transferenciaMonto);
        cuentaCorriente.ingreso(transferenciaMonto);
    }
}
