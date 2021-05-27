public class CuentaCorriente {

    private double saldo;
    private int numeroCuenta;

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
//        this.numeroCuenta = numeroCuenta;
    }

    public CuentaCorriente() {
        this.saldo = 0.0;
//        this.numeroCuenta = Math.random();
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo){
        this.saldo = saldo;
    }

    public void ingreso(double monto){
        this.saldo = this.saldo + monto;
    }

    public void egreso(double monto){
        this.saldo = this.saldo - monto;
    }

    public void transferencia(double monto, CuentaCorriente cuenta2){

        this.saldo = this.saldo - monto;
        cuenta2.ingreso(monto);
    }
}
