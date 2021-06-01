public class CuentaCorriente {
    private double saldo;
    private long numeroCuenta;

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void CuentaCorriente() {

    }

    public void CuentaCorriente(double saldo) {
        this.setSaldo(saldo);
    }

    public void CuentaCorriente(CuentaCorriente cuenta) {
        this.setSaldo(cuenta.getSaldo());
    }


    public void ingreso(double valor) {

    }

    public void egreso(double valor) {

    }

    public void reintegro(double valor) {

    }

    public void transferencia(CuentaCorriente origen, double monto) {

    }


}
