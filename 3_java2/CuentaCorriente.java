public class CuentaCorriente {
    private double saldo;
    private long numeroCuenta;


    //contructor con variables
    public CuentaCorriente(double saldo, long numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta= numeroCuenta;
    }

    //contructor vacio
    public CuentaCorriente() {
    }

    //contructor copia
    public CuentaCorriente(CuentaCorriente CuentaCorriente) {
        saldo = CuentaCorriente.getSaldo();
        numeroCuenta = CuentaCorriente.getNumeroCuenta();
    }



    //GET AND SET
    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public long getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(long numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }



    // METODOS
    public void ingreso(long numeroCuenta, double monto){
    }

    public void egreso(long numeroCuenta, double monto){

    }

    public void reintegro(CuentaCorriente cuentaCorriente){

    }

    public void transferencia(CuentaCorriente cuenta, double monto){

    }

}
