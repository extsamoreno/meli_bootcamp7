package practicaTM;

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

    public void ingreso(double monto) {
        this.saldo += monto;
    }

    public void egreso(double monto) {
        if (saldo>=monto) this.saldo -= monto;
    }

    public void reintegro(double monto) {
        this.ingreso(monto);
    }

    public void transferencia(double monto, CuentaCorriente cuentaReceptora) {
        this.egreso(monto);
        cuentaReceptora.ingreso(monto);
    }
}
