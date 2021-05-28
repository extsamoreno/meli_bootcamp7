public class Contador {
    private int valor;

    public Contador() {
        this.valor = 0;
    }
    public Contador(int valor) {
        this.valor = valor;
    }
    public Contador(Contador contador) {
        this.valor = contador.valor;
    }
    public void incrementar(int cantidadIncremento){
        this.valor += cantidadIncremento;
    }
    public void decrementar(int cantidadDecremento){
        this.valor -= cantidadDecremento;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
