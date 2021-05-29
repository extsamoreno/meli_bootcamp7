import java.time.LocalDateTime;

public class Time {
    long horaStart, horaStop;
    LocalDateTime now = LocalDateTime.now();

    public void start (){
        int hours = now.getHour();
        int minutes = now.getMinute();
        int seconds = now.getSecond();

        this.horaStart = horaMiliSec(hours,minutes,seconds);
    }

    public void start (int hour, int min, int sec){
        int hours = hour;
        int minutes = min;
        int seconds = sec;

        this.horaStart = horaMiliSec(hours,minutes,seconds);
    }

    public void stop (){
        int hours = now.getHour();
        int minutes = now.getMinute();
        int seconds = now.getSecond();

        this.horaStop = horaMiliSec(hours,minutes,seconds);
    }

    public void stop (int hour, int min, int sec){
        int hours = hour;
        int minutes = min;
        int seconds = sec;

        this.horaStop = horaMiliSec(hours,minutes,seconds);
    }

    public long elapsedTime() {
        return (this.horaStop - this.horaStart);
    }

    private long horaMiliSec(int hours, int minutes, int seconds){
        return  ((hours*3600) + (minutes*60) + seconds)*1000;
    }
}