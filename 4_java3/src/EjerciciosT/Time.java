package EjerciciosT;

public class Time {

    private long timeStart;
    private long timeStop;

    public void start() {
        timeStart = System.currentTimeMillis();
        //System.out.println(timeStart);
    }

    public void stop() {
        timeStop = System.currentTimeMillis();
        //System.out.println(timeStop);

    }

    public long elapsedTime() {
        return timeStop - timeStart;
    }
}
