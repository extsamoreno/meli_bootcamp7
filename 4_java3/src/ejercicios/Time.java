package ejercicios;

public class Time {
    private long startT;
    private long stopT;

    public void startTime(){ this.startT = System.currentTimeMillis();}

    public void stopTime(){
        this.stopT = System.currentTimeMillis();
    }

    public long enlapsedTime(){
        return this.stopT-this.startT;
    }

}
