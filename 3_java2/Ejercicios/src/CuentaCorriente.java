public class CuentaCorriente {

    private double saldo;

    // Constructores
    public CuentaCorriente(){
    }

    public CuentaCorriente(double saldo){
        this.saldo = saldo;
    }
    public CuentaCorriente(CuentaCorriente cuenta){
        this.saldo = cuenta.saldo;
    }


    // Metodos
    public void ingreso(double entrada){
        this.saldo += entrada;
    }

    public void egreso(double salida){
        this.saldo -= salida;
    }

    public void reintegro(double reintegro){
        this.saldo += reintegro;
    }

    public void transferencia(double salida){
        this.saldo -= salida;
    }


    // Getters y Setters
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
