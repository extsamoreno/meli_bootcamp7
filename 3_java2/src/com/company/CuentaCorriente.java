package com.company;

public class CuentaCorriente {
    private double saldo;

    public CuentaCorriente(){}

    public CuentaCorriente(int saldo){
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente copia){
        this.saldo = copia.getSaldo();
    }

    public void ingreso(double in){
        saldo=saldo+in;
    }

    public void egreso(double out){
        saldo=saldo-out;
    }

    public void reintegro(double monto){
        setSaldo(monto);
    }

    public void trasnferencia(CuentaCorriente cuenta, double monto){
        cuenta.ingreso(monto);
        egreso(monto);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
