package com.springbootday2.springbootday2.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class CalculatorService {
    public int getYears(int day, int month, int year) {
        int yearBirthday = 0;
        try {
            if (validateDate(day, month, year)){
                Date birthday = new SimpleDateFormat("yyyy-MM-dd").parse(year+"-"+month+"-"+day);
                Date dateNow = new Date();
                yearBirthday = obtenerAnios(birthday, dateNow);
            }
        }catch (ParseException e) {
            yearBirthday = -1;
        }
        return yearBirthday;
    }

    private boolean validateDate(int day, int month, int year)
    {
        GregorianCalendar Date = new GregorianCalendar();
        Date.setLenient(false);
        Date.set(year, month, day, 0, 0, 0);

        try{
            Date.getTime();
            System.out.println("Date is valid");
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    private int obtenerAnios(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                        a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }

    private Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
