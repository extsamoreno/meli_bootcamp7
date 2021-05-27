package com.company;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
public class Fecha {
    private int day;
    private int month;
    private int year;


    GregorianCalendar calendar = new GregorianCalendar();
    Calendar cal = Calendar.getInstance();
    public Fecha(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
        calendar.set(year,month,day);
    }

    public Date addDay(int days){

        calendar.add(Calendar.DAY_OF_YEAR,days);
        return calendar.getTime();
    }

    public boolean isValid(){
        try {
            LocalDate ld = LocalDate.of( year , month , day ) ;
            return true ;  // true = Valid data entered for a date.
        } catch ( DateTimeException e ) {
            // Exception caught, meaning invalid data-entry.
            return false;
        }

    }

    @Override
    public String toString() {
        return "Fecha{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                ", calendar=" + calendar +
                '}';
    }
}
