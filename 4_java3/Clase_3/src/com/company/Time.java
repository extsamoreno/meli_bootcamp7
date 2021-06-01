package com.company;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Time {

    private Timer timer = new Timer();
    private int segundos=0;
    public long startTime;
    public long endTime;


    public class Contador extends TimerTask {
        public void run() {
            segundos++;
        }
    }
    public void Iniciar()
    {
        this.segundos=0;
        timer = new Timer();
        timer.schedule(new Contador(), 0, 1000);
    }
    public void Detener() {

        timer.cancel();

    }

    public int elapsedTime() {
            return this.segundos ;
    }

}
