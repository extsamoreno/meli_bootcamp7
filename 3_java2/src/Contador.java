public class Contador {

    private int value;

    public Contador() { }

    public Contador(int value) {
        this.value = value;
    }

    public Contador(Contador contador) {
        this.value = contador.getValue();
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void increase(int amount){
        this.value += amount;
    }

    public void decrease(int amount){
        this.value -= amount;
    }
}
