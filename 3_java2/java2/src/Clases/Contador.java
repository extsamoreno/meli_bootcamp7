package Clases;

public class Contador {
    private int cont;

    public Contador() {
    }

    public Contador(int cont) {
        this.cont = cont;
    }

    public Contador(Contador contadorCopia) {
        this.cont = contadorCopia.getCont();
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public void incrementar() {
        cont++;
    }

    public void decrementar() {
        cont--;
    }

}