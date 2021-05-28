public class CuentaCorriente {

    private double saldo;
    private int numeroCuenta;

    public CuentaCorriente() {

    }

    public CuentaCorriente(double saldo, int numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente) {
       this.saldo = cuentaCorriente.saldo;
        this.numeroCuenta = cuentaCorriente.numeroCuenta;
    }

    public void ingreso() {

    }

    public void egreso() {

    }

    public void reintegro() {

    }

    public void transferencia() {

    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public int getNumeroCuenta() {
        return this.numeroCuenta;
    }
}
