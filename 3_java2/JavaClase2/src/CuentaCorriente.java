public class CuentaCorriente {

    private double saldo;
    private long numeroCuenta;

    public CuentaCorriente(){
    }

    public CuentaCorriente(double saldo, long numeroCuenta){
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;

    }

    public CuentaCorriente(CuentaCorriente copia){
        this.saldo = copia.getSaldo();
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

    public void ingreso(double monto){}
    public void egreso(double monto){}
    public void reintegro(double monto){}
    public void transferencia(CuentaCorriente cuentaDestino, double monto){}
}
