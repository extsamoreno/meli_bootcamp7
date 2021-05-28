package com.meli;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class Fecha {
    private int day, month, year;

    public Fecha() {
    }

    public Fecha(int day, int month, int year) throws Exception {
        if(validateDate(day,month,year)) {
            this.day = day;
            this.month = month;
            this.year = year;
        } else {
            throw new Exception("Fecha ingresada invalida");
        }

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

    public boolean validateDate(int day, int month, int year) {
        boolean valid = true;
        Calendar calendar = new GregorianCalendar(year, month-1, day);
        if (year != calendar.get(Calendar.YEAR)) {
            valid = false;
        }
        else if (month-1 != calendar.get(Calendar.MONTH)) {
            valid = false;
        }
        else if (day != calendar.get(Calendar.DAY_OF_MONTH)) {
            valid = false;
        }
        return valid;
    }

    public void addDay() {
        GregorianCalendar date = new GregorianCalendar(this.year, this.month, this.day);
        date.add(Calendar.DATE,1);
        this.year = date.get(Calendar.YEAR);
        this.month = date.get(Calendar.MONTH);
        this.day = date.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public String toString() {
        return "Fecha{" +
                "day='" + day + '\'' +
                ", month='" + month + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
