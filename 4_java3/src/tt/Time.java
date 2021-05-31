package tt;

public class Time {

    private long timeStart;
    private long timeStop;

    public void start() {
        timeStart = System.currentTimeMillis();
    }

    public void stop() {
        timeStop = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return timeStop - timeStart;
    }
}
