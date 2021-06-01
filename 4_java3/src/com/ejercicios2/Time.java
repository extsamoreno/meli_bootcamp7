package com.ejercicios2;

public class Time {

    private static long timeStart;
    private static long timeStop;

    public Time() {

    }

    public void start(){
        this.timeStart = System.currentTimeMillis();
    }

    public void stop(){
        this.timeStop = System.currentTimeMillis();
    }
    public long elapsedTime(){
        return timeStop - timeStart;
    }


}
