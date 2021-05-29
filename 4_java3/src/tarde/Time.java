package tarde;

import java.util.Date;

public class Time {
    private long start;
    private long stop;

    public void setStart(int start) {
        this.start = start;
    }
    public void setStop(int stop) {
        this.stop = stop;
    }
    public long getStart() {
        return start;
    }
    public long getStop() {
        return stop;
    }

    public void start(){
        this.start = System.currentTimeMillis();
    }

    public void stop(){
        this.stop = System.currentTimeMillis();
    }

    public long elapsedTime(){
        return stop-start;
    }

}
