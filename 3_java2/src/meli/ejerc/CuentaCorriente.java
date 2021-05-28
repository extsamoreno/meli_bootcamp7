package meli.ejerc;

public class CuentaCorriente {
    private double saldo;
    private long numeroCuenta;

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public CuentaCorriente(double saldo, long numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaCorriente(CuentaCorriente cuenta) {
        this.saldo = cuenta.getSaldo();
        this.numeroCuenta = cuenta.getNumeroCuenta();
    }

    public CuentaCorriente() {
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double monto) {
    }

    public void egreso(double monto) {
    }

    public void reintegro(double monto) {
    }

    public void transferencia(CuentaCorriente cuenta, double monto) {
    }

}
