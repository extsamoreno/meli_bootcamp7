package tm;

public class CuentaCorriente {

    private double saldo = 0;
    private int numeroCuenta = 0;

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo, int numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public CuentaCorriente(CuentaCorriente cuentaEntrada) {
        this.numeroCuenta = cuentaEntrada.getNumeroCuenta();
        this.saldo = cuentaEntrada.getSaldo();
    }

    public void ingreso(double valorIngreso) {
        this.saldo += valorIngreso;
    }

    public void egreso(double valorEgreso) {
        this.saldo -= valorEgreso;
    }

    public void reintegro(double valorReintegro) {
        this.saldo += valorReintegro;
    }

    public void transferencia(CuentaCorriente cuentadestino, double valor) {
        this.saldo -= valor;
        cuentadestino.setSaldo(cuentadestino.getSaldo() + valor);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
