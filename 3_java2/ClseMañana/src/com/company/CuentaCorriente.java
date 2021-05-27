package com.company;

public class CuentaCorriente {
    private double saldo;
    private String numeroCuenta;

    public CuentaCorriente(double saldo, String numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaCorriente() {
    }


    public void ingreso(double monto){
        this.saldo=this.saldo+monto;

    }
    public  void reintegro(double monto){
        this.saldo=this.saldo-monto;
    }
    public  void egreso(double monto){

        this.saldo=this.saldo-monto;

    }
    public  void transferencia(double monto,CuentaCorriente cuenta){

        this.saldo=this.saldo-monto;
        cuenta.ingreso(monto);

    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
