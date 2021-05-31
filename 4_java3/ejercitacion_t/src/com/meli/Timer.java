package com.meli;

public class Timer {
    private long start, stop;

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
