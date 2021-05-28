package meli.ejerc.Ej2;

public class Contador {
    int valor;

    public Contador() {
        this.valor = 0;
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public void incrementar () {
        this.valor += 1;
    }

    public void incrementar (int n) {
        this.valor += n;
    }

    public void decrementar () {
        this.valor -= 1;
    }

    public void decrementar (int n) {
        this.valor -= n;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
