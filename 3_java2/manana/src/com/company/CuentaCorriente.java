package com.company;

public class CuentaCorriente {
    private int saldo;
    private int numero_cuenta;

    public CuentaCorriente() {

    }
    public CuentaCorriente(int p1, int p2) {
        this.saldo = p1;
        this.numero_cuenta = p2;
    }

    public CuentaCorriente(CuentaCorriente copiado) {
        this.saldo = copiado.saldo;
        this.numero_cuenta = copiado.numero_cuenta;
    }

    public void ingreso(int plata) {
        this.saldo += plata;
    }

    public boolean egreso(int plata) {
        if (this.saldo >= plata) {
            this.saldo -= plata;
            return true;
        }
        return false;
    }

    public void reintegro(int plata) {
        this.saldo += plata;
    }

    public boolean transferencia(int plata) {
        if (this.saldo >= plata) {
            this.saldo -= plata;
            return true;
        }
        return false;
    }

    public int getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numero_cuenta;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public void setNumeroCuenta(int numero_cuenta) {
        this.numero_cuenta = numero_cuenta;
    }
}
