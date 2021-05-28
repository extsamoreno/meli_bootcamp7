public class Contador {

    private int counter;

    public Contador (int number) {this.counter = number;}
    public Contador (Contador contador) {this.counter = contador.counter;}
    public Contador () {this.counter = 0;}

    public void incrementar (int valor) {
        this.counter += valor;
    }

    public void decrementar (int valor) {
        this.counter -= valor;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

/*Crea una clase Contador (sí, contador de programación) con métodos que permitan incrementar y decrementar su valor. La clase contendrá un constructor por defecto, un constructor con parámetros, un constructor copia y los setters y getters (métodos de acceso) que corresponda.
 */