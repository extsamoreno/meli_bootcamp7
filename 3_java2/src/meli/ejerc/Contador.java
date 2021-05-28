package meli.ejerc;

public class Contador {
    private int valor;

    public Contador() {
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador cont) {
        this.valor = cont.getValor();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public static void incrementar(Contador contador, int cantidad) {
        contador.setValor(contador.getValor() + cantidad);
    }

}
