package javaDos;

public class Contador {
    private int numero;

    public Contador() {
        this.numero = 0;
    }

    public Contador(int numero) {
        this.numero = numero;
    }

    public Contador (Contador contador) {
        this.numero = contador.numero;
    }

    public void incrementar(){
        this.numero ++;
    }

    public void incrementar (int n) {
        this.numero += n;
    }

    public void decrementar() {
        this.numero --;
    }

    public void decrementar(int n){
        this.numero -= n;
    }
}
