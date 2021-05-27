package com.ejercicioMañana;

public class CuentaCorriente {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(){

    }

    public CuentaCorriente(double saldo){
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuenta){
        this.saldo = cuenta.saldo;
    }

    public void ingreso(double ingreso){
        saldo += ingreso;
    }

    public void egreso(double egreso){
        saldo -= egreso;
    }
    public void reintegro(double reintegro){
        ingreso(reintegro);
    }

    public void transferencia(double dinero, CuentaCorriente cuenta ){
        cuenta.ingreso(dinero);
        saldo -= dinero;
    }


}
