package com.ejercicioTarde;

public class Timer {
    private static long start, stop, totalTime;

    public static void start() {
        start = System.currentTimeMillis();
    }

    public static void stop() {
        stop = System.currentTimeMillis();
    }

    public static long elapsedTime() {
        return stop - start;
    }
}