package com.example.demo.ex2;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalculatorService {

    public int calcularEdad(int day, int month, int year){
        Calendar birthday = new GregorianCalendar(year, month, day);
        Calendar now = Calendar.getInstance();

        long age = (now.getTimeInMillis() - birthday.getTimeInMillis()) / 1000 / 60 / 60 / 24;
        int res = Double.valueOf(age / 365.25d).intValue();

        return res;
    }
}
