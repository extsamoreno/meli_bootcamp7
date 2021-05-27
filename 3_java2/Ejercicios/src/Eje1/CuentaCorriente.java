package Eje1;

public class CuentaCorriente {
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(){
        this.saldo = 0;
    }

    public CuentaCorriente(double saldo){
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente){
        this.saldo = cuentaCorriente.getSaldo();
    }

    public void ingreso(double monto){
        setSaldo(getSaldo()+monto);
    }

    public void egreso(double monto){
        setSaldo(getSaldo()-monto);
    }

    public void reintegro(CuentaCorriente cc){

    }
}
