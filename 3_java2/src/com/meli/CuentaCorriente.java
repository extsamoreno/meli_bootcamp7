package com.meli;

public class CuentaCorriente {
    private double saldo;
    private long numeroCuenta;

    // Constructor Default
    public void CuentaCorriente() {

    }

    // Constructor con parametros
    public void CuentaCorriente(double saldo, long numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    // Constructor Copiador
    public void CuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.saldo = cuentaCorriente.getSaldo();
        this.numeroCuenta = cuentaCorriente.getNumeroCuenta();
    }

    public void ingreso(double monto) {

    }

    public void egreso(double monto) {

    }

    public void reintegro(double mongo) {

    }

    public void transferencia(long numeroCuenta, CuentaCorriente cuentaCorrienteDestino, double valorTransferir) {

    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
