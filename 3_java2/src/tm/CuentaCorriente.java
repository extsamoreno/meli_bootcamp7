package tm;

public class CuentaCorriente {

    private double saldo;

    public double ingreso(double ingreso) {
        return this.saldo + ingreso;
    }

    public double egreso(double egreso) {
        return this.saldo - egreso;
    }

    public double reintegro(double reintegro) {
        return this.saldo + reintegro;
    }

    public double[] transferencia(int monto, int saldoCuentaDestino) {
         double saldoEmisor = this.saldo - monto;
         double saldoReceptor = saldoCuentaDestino + monto;

        return new double[]{saldoEmisor, saldoReceptor};
    }

    public CuentaCorriente() {
    }

    public CuentaCorriente(double saldo) {
        this.saldo = saldo;
    }

    public CuentaCorriente(CuentaCorriente cuentaCorriente) {
        this.saldo = cuentaCorriente.getSaldo();
    }


    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
