import java.time.LocalDateTime;

public class Time {
    long horaStart, horaStop;

    public void start (){ this.horaStart = System.currentTimeMillis();}

    public void stop (){this.horaStop = System.currentTimeMillis();}

    public long elapsedTime() { return (this.horaStop - this.horaStart);}

    public long getHoraStart() {
        return horaStart;
    }

    public void setHoraStart(long horaStart) {
        this.horaStart = horaStart;
    }

    public long getHoraStop() {
        return horaStop;
    }

    public void setHoraStop(long horaStop) {
        this.horaStop = horaStop;
    }
}