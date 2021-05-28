package mañana;

public class CuentaCorriente {


    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    //constructores
    public CuentaCorriente(){}

    public CuentaCorriente(double saldo){
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuenta){
        this.saldo = cuenta.saldo;
    }


    //metodos
    public void ingreso(double monto){
        this.saldo += monto;
    }

    public void egreso(double monto){
        this.saldo -= monto;
    }

    public void reintegro(double monto){
        this.saldo += monto;
    }

    public void transferencia(double monto){
        this.saldo += monto;
    }

}
