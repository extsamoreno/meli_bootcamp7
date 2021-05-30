package com.company;

public class Timer {

    private long start, stop, totalTime;

    public void start() {
        this.start = System.currentTimeMillis();
    }

    public void stop() {
        this.stop = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return this.stop - this.start;
    }

}
