package PracticaTarde;

public class Timer {
    static long start;
    static long stop;


    public void start(){
        start=System.currentTimeMillis();

    }


    public void stop(){
        stop=System.currentTimeMillis();

    }

    public long elapsedTime(){
        return stop-start;
    }

}
