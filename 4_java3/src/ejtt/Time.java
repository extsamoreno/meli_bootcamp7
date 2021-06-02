package ejtt;

public class Time {
    long start, end;

    public void startTime() {
        this.start = System.currentTimeMillis();
    }

    public void stopTime() {
        this.end = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return this.end - this.start;
    }
}
