//Crea una clase CuentaCorriente, con los métodos: ingreso, egreso reintegro y
// transferencia. La clase contendrá un constructor por defecto, uno con parámetros y otro que
// recibirá una CuentaCorriente de la cual copiará todos sus datos. Además se deben desarrollar
// los métodos de acceso (para cada variable de instancia de la clase, desarrollar un método set
// y otro get. Por ejemplo: si la clase tiene una variable double saldo, sus métodos de acceso
// serán: double getSaldo() y void setSaldo(double s). Los prototipos de los métodos y
// constructores deberán ser discutidos y diseñados en equipo.

package ejercicios;
public class CuentaCorriente {

    private double saldo;
    private int numeroCuenta;

    public CuentaCorriente(){
    }

    public CuentaCorriente (double saldo, int numeroCuenta) {
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    public void Cuentacorriente (CuentaCorriente cuenta){
        numeroCuenta=cuenta.getNumeroCuenta();
        saldo=cuenta.getSaldo();
    }

    public double getSaldo(){
        return this.saldo;
    }

    public void setSaldo(double saldo , int numeroCuenta){
        this.saldo = saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void ingreso(double monto){
        this.saldo = this.saldo + monto;
    }

    public void egreso(double monto){
        this.saldo = this.saldo - monto;
    }

    public void transferencia(double monto, CuentaCorriente cuenta2){
        this.saldo = this.saldo - monto;
        cuenta2.ingreso(monto);
    }

}
