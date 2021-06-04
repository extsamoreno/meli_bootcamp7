package cuentacorriente;
// Crea una clase CuentaCorriente.CuentaCorriente, con los métodos: ingreso, egreso, reintegro y transferencia.
// La clase contendrá un constructor por defecto, uno con parámetros y otro copia.
// Se deben desarrollar los métodos de acceso (para cada variable de instancia de la clase,
// desarrollar un método set y otro get.

public class CuentaCorriente {
    private String nro = "";
    private double saldo = 0;

    public CuentaCorriente() {
    }

    public CuentaCorriente(CuentaCorriente cta) {
        this(cta.nro, cta.saldo);
    }

    public CuentaCorriente(String nro, double saldo) {
        this.nro = nro;
        this.saldo = saldo;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
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
        this.saldo -= monto;
    }

    public void reintegro(double monto) {
        this.saldo += monto;
    }

    public void transferencia(CuentaCorriente cta, double monto) {
        this.saldo -= monto;
        cta.ingreso(monto);
    }

}


