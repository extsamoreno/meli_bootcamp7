public class Time {
    static long startTime, finalTime;
    public static void start(){
        startTime=System.currentTimeMillis();
    }
    public static void stop(){
        finalTime=System.currentTimeMillis();
    }

    public static long elapsedTime(){
        return finalTime-startTime;
    }
}
