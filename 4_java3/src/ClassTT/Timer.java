package ClassTT;

public class Timer {
    public long timeStart;
    public long timeStop;
    public  void start(){
        timeStart= System.currentTimeMillis();
    }
    public void stop(){
        timeStop= System.currentTimeMillis();
    }
    public long elapsedTime(){
        return timeStop-timeStart;
    }
}
