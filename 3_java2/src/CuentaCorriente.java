public class CuentaCorriente {
    private double saldo;
    private String numeroCuenta = "";

    public void CuentaCorriente() {
    }

    public void CuentaCorriente(String cuenta, double saldo) {
        this.saldo = saldo;
        this.numeroCuenta = cuenta;
    }


    public void CuentaCorriente(CuentaCorriente cuenta) {
        this.CuentaCorriente(cuenta.numeroCuenta, cuenta.getSaldo());
    }


    public void ingreso(double valor) {
        this.saldo += valor;
    }

    public void egreso(double valor) {
        this.saldo -= valor;
    }

    public void reintegro(double valor) {
        this.saldo += valor;
    }

    public void transferencia(CuentaCorriente destino, double monto) {
        this.saldo -= monto;
        destino.saldo += monto;
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }
}
