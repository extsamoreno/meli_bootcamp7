package javaDos;

public class CuentaCorriente {
    private String titular;
    private double saldo;

    //Constructor por defecto
    public CuentaCorriente() {
        this.titular = "";
        this.saldo = 0.00;
    }

    //Constructor con argumentos
    public CuentaCorriente(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo; // argumento = propiedad -> usar this
    }

    //Constructor copiador (a través de un objeto instanciado)
    public CuentaCorriente (CuentaCorriente cc) { //
        this.titular = cc.titular;
        this.saldo = cc.saldo;
    }

    public void ingreso(double cantidad){
        this.saldo += cantidad;
    }

    public void egreso(double cantidad){
        this.saldo -= cantidad;
    }

    public void reintegro(double cantidad){
        ingreso(cantidad);
    }

    public void transferencia (CuentaCorriente cc, double saldo) {

    }

    //Getter y Setter
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
