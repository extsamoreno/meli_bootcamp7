package ejercicio2;

public class Contador {
    private int counter;

    public Contador(int contador) {
        this.counter = contador;
    }

    public Contador() {
        this.counter = 0;
    }

    public Contador(Contador contador) {
        this.counter = contador.getCounter();
    }

    public void incrementarValor(){
        this.counter++;
    }

    public void decrementarValor(){
        this.counter--;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}

