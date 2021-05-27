public class Contador {

    private int valor;

    // Constructores
    public Contador() {
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador cont) {
        this.valor = cont.valor;
    }


    // Metodos
    public void incrementarValor(){
        this.valor++;
    }

    public void decrementarValor(){
        this.valor--;
    }


    // Getters y Setters
    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
