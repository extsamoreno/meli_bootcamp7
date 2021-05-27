public class CuentaCorriente {

    private double saldo;
    private long numeroCuenta;

    public CuentaCorriente() {

    }

    public CuentaCorriente(double saldo, long numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaCorriente(CuentaCorriente copia) {
        this.saldo = copia.getSaldo();
        this.numeroCuenta = copia.getNumeroCuenta();
    }


    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public long getNumeroCuenta() {
        return this.numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
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
