public class CuentaCorriente {
    private String titular;
    private double saldo;

    CuentaCorriente(){
        this.titular = "";
        this.saldo = 0;
    }

    CuentaCorriente(CuentaCorriente cc){
        this.titular = cc.titular;
        this.saldo = cc.saldo;
    }

    void ingreso(double monto){
        this.saldo += monto;
    }

    void egreso(double monto){
        if(this.saldo - monto >= 0){
            this.saldo -= monto;
        }else{
            System.out.println("El monto ingresado a retirar es superior al que posee actualmente");
        }
    }

    void reintegro(double monto){
        ingreso(monto);
    }

    void transferencia(double monto, CuentaCorriente cc){
        cc.ingreso(monto);
        egreso(monto);
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }
}
