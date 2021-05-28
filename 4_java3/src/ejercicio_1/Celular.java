package ejercicio_1;

public class Celular implements Precedable<Celular> {
    private double numero;
    private String titular;

    public Celular(double numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    public double getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
        if (this.numero < celular.numero) {
            return 1;
        }
        else
            return 0;
    }
}
