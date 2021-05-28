package tm;

public class Contador {
    private int cont = 0;

    public Contador() {
    }

    public Contador(int cont) {
        this.cont = cont;
    }

    public Contador(Contador entrada) {
        this.cont = entrada.getCont();
    }

    public void incrementar() {
        this.cont++;
    }

    public void incrementar(int incremento) {
        this.cont += incremento;
    }

    public void decrementar() {
        this.cont--;
    }

    public void decrementar(int decremento) {
        this.cont -= decremento;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }
}
