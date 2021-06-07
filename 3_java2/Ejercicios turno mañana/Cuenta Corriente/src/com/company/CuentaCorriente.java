package com.company;

public class CuentaCorriente {
    private String numeroCuenta;
    private double saldo;

    public CuentaCorriente(){

    }

    public CuentaCorriente(CuentaCorriente cta){
        this.numeroCuenta = cta.numeroCuenta;
        this.saldo = cta.saldo;
    }

    public CuentaCorriente(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaCorriente(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso (double monto){
        this.saldo += monto;
    }

    public void egreso (double monto){
        this.saldo -= monto;
    }

    public void reintegro(double monto){
        this.saldo += monto;
    }

    public void transferencia(CuentaCorriente cta, double monto){
        cta.saldo -= monto;
        cta.ingreso(monto);
    }


}
