public class Contador {
    private int valor;

    public Contador() {
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador contador) {
        this.valor = contador.valor;
    }

    public void incrementar(int cuanto) {
        this.valor += cuanto;
    }

    public void decremento(int cuanto) {
        this.valor -= cuanto;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
