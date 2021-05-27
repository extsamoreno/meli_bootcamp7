public class CuentaCorriente {
    /*Crea una clase CuentaCorriente, con los métodos: ingreso, egreso, reintegro y transferencia.
    La clase contendrá un constructor por defecto, uno con parámetros y otro que recibirá una CuentaCorriente de la cual copiará todos sus datos.
    Además se deben desarrollar los métodos de acceso (para cada variable de instancia de la clase, desarrollar un método set y otro get.
    Por ejemplo: si la clase tiene una variable double saldo, sus métodos de acceso serán: double getSaldo() y void setSaldo(double s).
    Los prototipos de los métodos y constructores deberán ser discutidos y diseñados en equipo.
     */


    private double saldo;
    private double reintegro;

    public CuentaCorriente(){

    }
    public CuentaCorriente(double saldo, double reintegro){
        this.saldo=saldo;
        this.reintegro=reintegro;
    }
    public CuentaCorriente(CuentaCorriente objeto){
        this.saldo=objeto.saldo;
        this.reintegro= objeto.reintegro;
    }

    public void ingreso(double ingreso){
        this.saldo+=ingreso;
    }

    public void egreso(double egreso){
        if(this.saldo-egreso >= 0)
            this.saldo-=egreso;
    }

    public double reintegro(double reintegro){
        reintegro = this.reintegro;
        return reintegro;
    }

    public boolean transferencia(CuentaCorriente objeto, double cantidad, String accion){
        if(accion == "enviar"){
            if(this.saldo-cantidad>=0){
                objeto.saldo+=cantidad;
                this.saldo-=cantidad;
                return true;
            }
            else
                return false;
        }
        if(accion == "recibir"){
            if(objeto.saldo-cantidad>=0){
                this.saldo+=cantidad;
                objeto.saldo-=cantidad;
                return true;
            }
            else
                return false;
        }
        return false;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getReintegro() {
        return reintegro;
    }

    public void setReintegro(double reintegro) {
        this.reintegro = reintegro;
    }
}
