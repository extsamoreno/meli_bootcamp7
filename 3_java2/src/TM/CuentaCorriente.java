package TM;

public class CuentaCorriente {
    private double saldo;
    private double nCuenta;

    public CuentaCorriente() {}

    public CuentaCorriente(double saldo, double cuenta) {
        // No es necesario que el constructor llame al setter y al getter, puede acceder directamente a las variables
        // por mas que sean privadas
        this.saldo = saldo;
        this.nCuenta = cuenta;
    }

    public CuentaCorriente(CuentaCorriente cuenta) {
        setSaldo(cuenta.saldo);
        setNumCuenta(cuenta.nCuenta);
    }

    public void setSaldo(double s) {
        this.saldo = s;
    }
    public double getSaldo() {
        return this.saldo;
    }
    public void setNumCuenta(double c) {
        this.nCuenta = c;
    }
    public double getNumCuenta() {
        return this.nCuenta;
    }
}
