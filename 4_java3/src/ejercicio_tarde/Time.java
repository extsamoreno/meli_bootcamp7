package ejercicio_tarde;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Time {
    long milliSeconds;
    long milliSeconds1;
    long totalTime;
    public void start(){
        LocalDateTime now = LocalDateTime.now();
        this.milliSeconds = Timestamp.valueOf(now).getTime();
        System.out.println("Hora en MilliSeconds START: "+milliSeconds);

    }
    public void stop (){
        LocalDateTime now = LocalDateTime.now();
        this.milliSeconds1 = Timestamp.valueOf(now).getTime();
        System.out.println("Hora en MilliSeconds STOP: "+milliSeconds1);
    }
    public long elapsedTime(){
        this.totalTime=this.milliSeconds1-this.milliSeconds;
        return this.totalTime;
    }
}
