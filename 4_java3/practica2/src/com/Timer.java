package com;

public class Timer {

    static long startTime;
    static long stopTime;

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static void stop() {
        stopTime = System.currentTimeMillis();
    }

    public static long elapsedTime() {
        return stopTime - startTime;
    }
}
