package Ejercicio1;

public class CuentaCorriente {

    // atributos
    private String idCuenta;
    private double saldo;

    // Constructores
    public CuentaCorriente(){
        idCuenta ="";
        saldo=0;
    }
    public CuentaCorriente(String idCuenta, int saldo){
        this.idCuenta =idCuenta;
        this.saldo=saldo;
    }

    public CuentaCorriente(CuentaCorriente cuenta){
        idCuenta = cuenta.idCuenta;
        saldo= cuenta.saldo;
    }

    //SET Y GETTEERS

    public double getSaldo() {
        return saldo;
    }

    public String getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(String idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Metodos

    public void ingreso(double valor){
        if(valor>0.0){
            saldo+=valor;
        }
        else{
            System.out.println("El valor debe ser mayor a 0.0");
        }
    }

    public void egreso(double valor){
        if(valor>0.0){
            saldo-=valor;
        }
        else{
            System.out.println("El valor debe ser mayor a 0.0");
        }
    }
    public static void transferencia(double valor, CuentaCorriente cEmisor, CuentaCorriente cReceptor){
        cEmisor.setSaldo(cEmisor.getSaldo()-valor);
        cReceptor.setSaldo(cReceptor.getSaldo()+valor);
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "idCuenta='" + idCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }

}







