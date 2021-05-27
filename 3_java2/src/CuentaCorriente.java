public class CuentaCorriente {
    private double saldo;

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cc){
        this.saldo = cc.getSaldo();
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double monto){
        this.saldo+=monto;
    }

    public void egreso(double monto){
        this.saldo-=monto;
    }

    public void reintregro(CuentaCorriente cc, double monto){
        this.saldo+=monto;
        cc.egreso(monto);
    }

    public void transferencia(CuentaCorriente cc, double monto){
        this.saldo-=monto;
        cc.ingreso(monto);
    }
}
