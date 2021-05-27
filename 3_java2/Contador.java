public class Contador {

    private int valor;


    public Contador() {
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador copia) {
        this.valor = copia.getValor();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void incrementar(int cuanto) {
        this.valor += cuanto;
    }

    public void decrementar(int cuanto) {
        this.valor -= cuanto;
    }


}
