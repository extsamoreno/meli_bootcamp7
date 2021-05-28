public class CuentaCorriente {

    private Integer numeroCuenta;
    private double saldo;

    public CuentaCorriente() {
    }

    public CuentaCorriente(Integer numeroCuenta, double valorCuenta) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = valorCuenta;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.numeroCuenta = cuentaCorriente.getNumeroCuenta();
        this.saldo = cuentaCorriente.getSaldo();
    }

    public void ingreso (Integer ingreso){
        this.saldo = this.saldo + ingreso;

    }

    public void egreso (Integer egreso){
        this.saldo = this.saldo - egreso;
    }

    public void reintegro (Integer reintegro){
        this.saldo = this.saldo - reintegro;

    }

    public void tranferencia (Integer transferencia){
        this.saldo = this.saldo - transferencia;
    }


    public Integer getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumeroCuenta(Integer numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
