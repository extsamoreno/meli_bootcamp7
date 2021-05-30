public class CuentaCorriente {

    private double saldo;
    private long numeroCuenta;

    public CuentaCorriente(){
    }

    public CuentaCorriente(double saldo, long numeroCuenta){
        this.setSaldo(saldo);
        this.setNumeroCuenta(numeroCuenta);
    }

    public CuentaCorriente(CuentaCorriente copia){
        this.setSaldo(copia.getSaldo());
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public long getNumeroCuenta(){
        return this.numeroCuenta;
    }

    public void ingreso(double monto){
        this.setSaldo(this.getSaldo() + monto);
    }

    public void egreso(double monto){
        this.setSaldo(this.getSaldo() - monto);
    }

    public void reintegro(double monto){
        this.setSaldo(this.getSaldo() + monto);
    }

    public void transferencia(CuentaCorriente cuentaDestino, double monto){
        this.egreso(monto);
        cuentaDestino.ingreso(monto);
    }
}
