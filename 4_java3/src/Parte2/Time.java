package Parte2;

public class Time {

    private long start;
    private long stop;

    public Time() {
    }

    public void start(){
        setStart(System.currentTimeMillis());
    }

    public void stop(){
        setStop(System.currentTimeMillis());
    }

    public long  elapsedTime(){
        return getStop() - getStart() ;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getStop() {
        return stop;
    }
    public void setStop(long stop) {
        this.stop = stop;
    }

}
