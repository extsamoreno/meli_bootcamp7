package tm;

public class Contador {

    private int counter;

    public void incrementCounter() {
        this.counter++;
    }

    public void decreaseCounter() {
        this.counter--;
    }

    public Contador() {
    }

    public Contador(int counter) {
        this.counter = counter;
    }

    public Contador(Contador contador) {
        this.counter = contador.counter;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }
}
