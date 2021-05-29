package com.company.ejTarde;

public class Time {

    private long startTime;
    private long stopTime;

    public Time() {
        this.startTime = 0;
        this.stopTime = 0;
    }

    public void start() {
        startTime = System.currentTimeMillis();
    }

    public void stop() {
        stopTime = System.currentTimeMillis();
    }

    public long elapsedTime() {
        return stopTime - startTime;
    }

}
