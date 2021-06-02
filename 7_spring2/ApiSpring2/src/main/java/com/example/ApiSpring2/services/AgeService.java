package com.example.ApiSpring2.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class AgeService {
    public static int obtainAge(int day, int month, int year) {
        try {
            if(validateDate(day,month,year)) {
                Date birthdate = new SimpleDateFormat("dd/MM/yyyy").parse(day + "/" + month + "/" + year);
                Calendar a = getCalendar(birthdate);
                Calendar b = getCalendar(new Date());
                int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
                if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) ||
                        (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) &&
                                a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
                    --diff;
                }
                return diff;
            }
            return -1;
        }
        catch (Exception ex){
            System.out.println(ex.getStackTrace());
            return -1;
        }

    }
    public static boolean validateDate(int Day, int Month, int Year)
    {
        GregorianCalendar Date = new GregorianCalendar();
        Date.setLenient(false);
        Date.set(Year, Month, Day, 0, 0, 0);

        try{
            Date.getTime();
            System.out.println("Date is valid");
            return true;
        }catch (Exception e){
            System.out.println("Date is invalid please try again");
            return false;
        }
    }

    public static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }
}
