public class Contador {
    private int count;

    public Contador() {
    }

    public Contador(int count) {
        this.count = count;
    }

    public Contador(Contador contador) {
        this.count = contador.getCount();
    }

    public void increment(){
        this.setCount(this.getCount() + 1);
    }

    public void increment(int num){
        this.setCount(this.getCount() + num);
    }

    public void decrement(){
        this.setCount(this.getCount() - 1);
    }

    public void decrement(int num){
        this.setCount(this.getCount() - num);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
