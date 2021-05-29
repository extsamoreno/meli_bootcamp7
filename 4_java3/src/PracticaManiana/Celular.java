package PracticaManiana;

public class Celular implements Precedable<Celular> {
    private int numero;
    private String titular;

    public Celular(String titular, int numero) {
        this.numero = numero;
        this.titular = titular;
    }

    public int getNumero() {
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
    public int precedeA (Celular c) {
        return this.titular.compareTo(c.titular);
    }

    @Override
    public String toString(){
        return "Titular: " + this.getTitular() + ", Número: " + this.getNumero();
    }
}
