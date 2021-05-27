public class Counter {

    private int value;

    public Counter (){
        this.value = 0;
    }
    public Counter (int value){
        this.value= value;
    }


    
    public int getValue() {
        return value;
    }


    public void setValue(int value) {
        this.value = value;
    }

    public void increment(int increment){

        this.value +=increment;
    }
    public void increment (){

        this.increment(1);
    }

    public void decrement(int increment){

        this.value -=increment;
    }
    public void decrement (){

        this.increment(1);
    }

}
