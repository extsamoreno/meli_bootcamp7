public class CuentaCorriente {

    private double saldo;

    public CuentaCorriente (double saldo) {this.saldo = saldo;}
    public CuentaCorriente () {this.saldo = 0;}
    public CuentaCorriente (CuentaCorriente cuentaCorriente) {this.saldo = cuentaCorriente.saldo;}

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso (double monto) {
        this.saldo += monto;
    }

    public void egreso (double monto) {
        this.saldo -= monto;
    }

    public void reintegro (double monto, CuentaCorriente cuenta2) {
        cuenta2.egreso(monto);
        ingreso(monto);
    }

    public void transferencia (double monto, CuentaCorriente cuenta2) {
        egreso(monto);
        cuenta2.ingreso(monto);
    }
}

/*Crea una clase CuentaCorriente, con los métodos: ingreso, egreso, reintegro y transferencia. La clase contendrá un constructor por defecto, uno con parámetros y otro que recibirá una CuentaCorriente de la cual copiará todos sus datos. Además se deben desarrollar los métodos de acceso (para cada variable de instancia de la clase, desarrollar un método set y otro get. Por ejemplo: si la clase tiene una variable double saldo, sus métodos de acceso serán: double getSaldo() y void setSaldo(double s). Los prototipos de los métodos y constructores deberán ser discutidos y diseñados en equipo.*/
