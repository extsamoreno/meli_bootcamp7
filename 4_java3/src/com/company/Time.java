package com.company;

import java.util.Date;

public class Time {
    private Date start;
    private Date end;

    public void start() {
        this.start = new Date();
    }

    public void stop() {
        this.end = new Date();
    }

    public long elapsedTime() {
        return this.start.getTime() - this.end.getTime();
    }

    @Override
    public String toString() {
        return "{ start : " + this.start.getTime() + ", end : " + this.end.getTime() + ", elapsed : "+ elapsedTime() + " }";
    }
}
