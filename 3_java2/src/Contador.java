public class Contador {
    private int counter;

    public Contador() {
    }

    public Contador(int counter) {
        this.counter = 0;
    }

    public Contador(Contador c){
        this.counter= c.getCounter();
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void incrementar(){
        this.counter++;
    }

    public void decrementar(){
        this.counter--;
    }
}
