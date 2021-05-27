package ejercicios;

public class CuentaCorriente {

    // Atributos
    private String titular;
    private int numero;
    private double saldo;

    // Constructor por defecto
    public CuentaCorriente(){
        this.titular = "Yolo";
        this.numero = 100;
        this.saldo = 100;
    }

    // Constructor con parámetros
    public CuentaCorriente(String titular, double saldo) {
        this.titular = titular;
        this.numero = 200;
        this.saldo = saldo;
    }

    // Constructor copiador
    public CuentaCorriente(CuentaCorriente cc){
        this.titular = cc.titular;
        this.numero = cc.numero + 1;
        this.saldo = cc.saldo;
    }

    // Métodos

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void ingreso(double monto){
        this.saldo += monto;
    }

    public void egreso(double monto){
        this.saldo -= monto;
    }

    public String reintegro(double monto){
        this.saldo += monto;
        return "Reintegro";
    }

    public Object[] transferencia(CuentaCorriente cc, double monto){
        this.saldo -= monto;
        cc.ingreso(monto);
        Object[] salida = new Object[2];
        salida[0] = cc.numero;
        salida[1] = monto;
        return salida;
    }

    public String imprimirTransferencia(Object[] salida){
        return "Transferido a: " +salida[0]+ " Cantidad: " +salida[1];
    };

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "titular='" + titular + '\'' +
                ", numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
