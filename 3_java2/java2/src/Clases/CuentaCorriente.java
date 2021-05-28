package Clases;

public class CuentaCorriente {
    private double saldo;

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuenta) {
        this.saldo = cuenta.getSaldo();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double ingreso) {
        this.saldo += ingreso;
    }

    public boolean egreso(double egreso) {
        if(this.saldo >= egreso) {
            this.saldo -= egreso;
            return true;
        }
        return false;
    }

    public void reintegro(double monto) {
        this.ingreso(monto);
    }

    public void transferencia(double monto, CuentaCorriente cuentaReceptora) {
        this.egreso(monto);
        cuentaReceptora.ingreso(monto);
    }
}