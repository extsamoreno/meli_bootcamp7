package meli.ejerc.Ej1;

public class Celular implements Precedable<Celular>{
    private int numero;
    private String titular;

    public Celular(int numero, String titular) {
        this.numero = numero;
        this.titular = titular;
    }

    @Override
    public int precedeA(Celular celular) {
        if (this.numero > celular.numero) {
            return 0;
        } else return 1;
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
}