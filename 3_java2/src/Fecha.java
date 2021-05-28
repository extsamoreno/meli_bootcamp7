
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    private int day;
    private int month;
    private int year;

    public Fecha() {
        GregorianCalendar gc = new GregorianCalendar();
        this.day = gc.get(Calendar.DAY_OF_MONTH);
        this.month = gc.get(Calendar.MONTH) + 1;
        this.year = gc.get(Calendar.YEAR);
    }

    public Fecha(int dia, int mes, int anio) {
        GregorianCalendar gc = new GregorianCalendar(anio, mes-1, dia);
        this.day = gc.get(Calendar.DAY_OF_MONTH);
        this.month = gc.get(Calendar.MONTH) +1;
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

    public static boolean isCorrectDate(int day, int month, int year) {

        GregorianCalendar gc = new GregorianCalendar(year, month-1, 1);
        int maxDay = 0;

        if(year < 1) {
            return false;
        }

        if(month > 12 || month < 1) {
            return false;
        }

        maxDay = gc.getActualMaximum(Calendar.DAY_OF_MONTH);

        if(day > maxDay) {
            return false;
        }

        return true;

    }

    public void addDays(int days) {
        GregorianCalendar gc = new GregorianCalendar(this.year, this.month-1, this.day);
        gc.add(Calendar.DAY_OF_MONTH, days);
        this.day = gc.get(Calendar.DAY_OF_MONTH);
        this.month = gc.get(Calendar.MONTH) +1;
        this.year = gc.get(Calendar.YEAR);
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }






}
