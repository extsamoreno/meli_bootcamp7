package practicaTT;

public class Time {
    private long start;
    private long stop;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        stop = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return stop - start;
    }
}
