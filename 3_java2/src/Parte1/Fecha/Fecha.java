package Parte1.Fecha;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Fecha {
    //día mes y año
    int day;
    int month;
    int year;

    public Fecha(int day, int month, int year) {
        Calendar calendar = checkDate(day, month, year);
        this.day = calendar.get(Calendar.DATE);
        this.month = calendar.get(Calendar.MONTH);
        this.year = calendar.get(Calendar.YEAR);
    }

    public Calendar checkDate(int day, int month, int year){
        GregorianCalendar calendar = new GregorianCalendar(year, month,day);
        return calendar;
    }

    public void incrementDay(){
        Calendar calendar = checkDate(this.day + 1, this.month, this.year);
        setDay(calendar.get(Calendar.DATE));
        setMonth(calendar.get(Calendar.MONTH));
        setYear(calendar.get(Calendar.YEAR));
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

    @Override
    public String toString() {
        return this.getDay() + "/" + this.getMonth() + "/" + this.getYear();
    }
}
