public class Contador {
    private int valor = 0;

    public Contador() {
        this(0);
    }

    public Contador(Contador cont) {
        this(cont.valor);
    }

    public Contador(int ini) {
        this.valor = ini;
    }

    public void incre() {
        this.valor++;
    }

    public void decre() {
        this.valor--;
    }
}
