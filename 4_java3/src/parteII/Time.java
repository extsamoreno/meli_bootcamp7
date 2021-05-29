package parteII;

public class Time {
    private long startTime;
    private long stopTime;

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }

    public void start(){
        this.setStartTime(java.lang.System.currentTimeMillis());
    }
    public void stop(){
        this.setStopTime(java.lang.System.currentTimeMillis());
    }
    public long elapsedTime(){
        return this.getStopTime() - this.getStartTime();
    }
}
