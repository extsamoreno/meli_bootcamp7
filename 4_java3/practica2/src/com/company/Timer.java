package com.company;

public class Timer {
    long startTime;
    long stopTime;

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
