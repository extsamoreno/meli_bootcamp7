public class CuentaCorriente {

    private double saldo;

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente){
        this.saldo = cuentaCorriente.getSaldo();
    }

    public void ingreso(double dinero){
        this.saldo += dinero;
    }
    public void egreso (double dinero){
        this.saldo -= dinero;
    }

    public void reintegro(double dinero){
        ingreso(dinero);
    }
    public void  transferencia(CuentaCorriente cuentaCorriente, double dinero){
        egreso(dinero);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
