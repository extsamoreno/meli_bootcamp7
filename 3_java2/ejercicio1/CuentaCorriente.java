package ejercicio1;

import org.jetbrains.annotations.NotNull;

public class CuentaCorriente {
    private double saldo;

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente() {
        this.saldo = 0.0;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.saldo = cuentaCorriente.getSaldo();
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

    public void transferencia(double monto, @NotNull CuentaCorriente cuentaInicial, @NotNull CuentaCorriente cuentaATransferir){
        cuentaInicial.egreso(monto);
        cuentaATransferir.ingreso(monto);
    }
}
