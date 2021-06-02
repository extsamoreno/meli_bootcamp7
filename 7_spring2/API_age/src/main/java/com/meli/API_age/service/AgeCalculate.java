package com.meli.API_age.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgeCalculate {
    public static int calculate(int day, int month, int year) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyy");
        Date today = new Date();
        Date dateToday = new Date();
        Date dateDelivered = dateFormat.parse(AgeCalculate.parserDate(day, month, year));
        int dias = (int) ((dateToday.getTime() - dateDelivered.getTime()) / (86400000 * 360.5));
        return dias;
    }

    private static String parserDate(int day, int mont, int year) {
        String sDay = "";
        String sMonth = "";
        String sYear = year + "";
        // Days
        if ( day < 10) {
            sDay = "0" + day;
        } else {
            sDay = day + "";
        }
        // Mont
        if ( day < 10) {
            sMonth = "0" + mont;
        } else {
            sMonth = mont + "";
        }
        return sDay + "/" + sMonth + "/" + sYear;
    }
}
