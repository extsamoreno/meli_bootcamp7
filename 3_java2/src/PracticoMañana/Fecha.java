import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha{
    GregorianCalendar gc;
    private int day;
    private int month;
    private int year;

    public Fecha(){
        gc = new GregorianCalendar();
        this.day = gc.get(Calendar.DAY_OF_MONTH);
        this.month = gc.get(Calendar.MONTH);
        this.year = gc.get(Calendar.YEAR);
    }

    public Fecha(int day, int month, int year) {
        gc = new GregorianCalendar(day,month,year);
        this.day = gc.get(Calendar.DAY_OF_MONTH);
        this.month = gc.get(Calendar.MONTH);
        this.year = gc.get(Calendar.YEAR);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
