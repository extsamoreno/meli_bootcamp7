public class CuentaCorriente {
    private double saldo;

    public CuentaCorriente () {

    }

    // se asegura de que el saldo sea siempre mayor a cero
    public CuentaCorriente (double saldoInicial) {
        if (saldoInicial > 0.0) {
            saldo = saldoInicial;
        }
    }

    // constructor copiador
    public CuentaCorriente (CuentaCorriente cuentaCorriente) {
        this.saldo = cuentaCorriente.obtenerSaldo();
    }


    // métodos
    public void ingreso (double monto) {
        saldo += monto;
    }

    public double egreso (double monto) {
        return saldo -= monto;
    }

    public void reintegro (double monto) {
        ingreso(monto);
    }

    public void transferencia (double monto, CuentaCorriente cuentaDestino) {
        saldo -= monto;
        cuentaDestino.saldo += monto;
    }

    // métodos de acceso
    public double obtenerSaldo () {
        return saldo;
    }

    public void establecerSaldo (int saldo) {
        this.saldo = saldo;
    }

}