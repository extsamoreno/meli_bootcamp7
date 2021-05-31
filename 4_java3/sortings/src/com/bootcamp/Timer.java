package com.bootcamp;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Timer {

    private LocalTime startTime;
    private LocalTime endTime;

    public void start() {
        this.startTime = LocalTime.now();
    }

    public void stop() {
        this.endTime = LocalTime.now();
    }


    public long elapsedTime() {
        return this.startTime.until(endTime, ChronoUnit.MILLIS);
    }

}
